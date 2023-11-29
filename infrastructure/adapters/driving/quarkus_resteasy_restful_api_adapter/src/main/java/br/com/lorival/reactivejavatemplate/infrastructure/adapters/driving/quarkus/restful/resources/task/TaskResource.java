package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.task;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CompleteTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.CreateTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetTasksApplicationService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.TasksApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;

@RequiredArgsConstructor
public class TaskResource implements TasksApi {

  private final CreateTaskApplicationService createTaskService;
  private final GetTasksApplicationService getTasksService;
  private final CompleteTaskApplicationService completeTaskService;
  private final TaskResponseMapper responseMapper;

  @Override
  public Uni<Response> tasksGet() {
    return getTasksService
        .get()
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(responseMapper::toResponse)
        .collect()
        .asList()
        .map(list -> Response.ok(list).build());
  }

  @Override
  public Uni<Response> tasksPost(TaskRequest request) {
    return createTaskService
        .create(request.getDetail())
        .map(task -> Response.status(CREATED).entity(responseMapper.toResponse(task)).build());
  }

  @Override
  public Uni<Response> updateTaskAsCompleted(Long taskID) {
    return completeTaskService
        .complete(taskID)
        .onItem()
        .transformToUni(ignored -> Uni.createFrom().item(Response.noContent().build()))
        .onFailure()
        .recoverWithItem(Response.status(Response.Status.NOT_FOUND).build());
  }
}
