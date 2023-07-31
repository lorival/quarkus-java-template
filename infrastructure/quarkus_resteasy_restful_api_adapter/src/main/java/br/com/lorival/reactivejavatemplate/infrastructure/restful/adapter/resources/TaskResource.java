package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.resources;

import static jakarta.ws.rs.core.Response.Status.CREATED;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.mappers.TaskMapper;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.TaskController;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.openapi.quarkus.openapi_yml.api.DefaultApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;

public class TaskResource implements DefaultApi {

  @Inject private TaskController controller;
  @Inject private TaskMapper mapper;

  @Override
  public Uni<Response> tasksGet() {
    return controller
        .get()
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
    return controller
        .create(taskInput.getDetail())
        .map(task -> Response.status(CREATED).entity(mapper.toResponse(task)).build());
  }
}
