package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import br.com.lorival.reactivejavatemplate.app.usecases.CompleteTaskUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.CreateTaskUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.GetTasksUseCase;
import br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.mappers.TaskResponseMapper;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.TasksApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;

@RequiredArgsConstructor
public class TaskResource implements TasksApi {

  private final CreateTaskUseCase createTaskUseCase;
  private final GetTasksUseCase getTasksUseCase;
  private final CompleteTaskUseCase completeTaskUseCase;
  private final TaskResponseMapper responseMapper;

  @Override
  public Uni<Response> tasksGet() {
    return getTasksUseCase
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
  public Uni<Response> tasksPost(TaskRequest taskInput) {
    return createTaskUseCase
        .create(taskInput.getDetail())
        .map(task -> Response.status(CREATED).entity(responseMapper.toResponse(task)).build());
  }

  @Override
  public Uni<Response> updateTaskAsCompleted(Long taskID) {
    return completeTaskUseCase
        .complete(taskID)
        .onItem()
        .transformToUni(ignored -> Uni.createFrom().item(Response.noContent().build()))
        .onFailure()
        .recoverWithItem(Response.status(Response.Status.NOT_FOUND).build());
  }
}
