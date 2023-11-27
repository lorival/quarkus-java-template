package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import br.com.lorival.reactivejavatemplate.app.usecases.CreateTaskUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.GetTasksUseCase;
import br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.mappers.TaskResponseMapper;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.DefaultApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;

@RequiredArgsConstructor
public class TaskResource implements DefaultApi {
  private final CreateTaskUseCase createTaskUseCase;
  private final GetTasksUseCase getTasksUseCase;
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
}
