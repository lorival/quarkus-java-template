package br.com.lorival;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import br.com.lorival.tasks.repositories.UserRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.openapi.quarkus.openapi_yml.api.DefaultApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;

public class TasksResource implements DefaultApi {

  @Inject private UserRepository repository;
  @Inject private TaskMapper mapper;

  @Override
  public Uni<Response> tasksGet() {
    return repository
        .findAll()
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(entity -> mapper.toResponse(entity))
        .collect()
        .asList()
        .map(list -> Response.ok(list).build());
  }

  @Override
  public Uni<Response> tasksPost(TaskRequest taskInput) {
    return repository
        .save(mapper.toTask(taskInput))
        .map(task -> Response.status(CREATED).entity(mapper.toResponse(task)).build());
  }
}
