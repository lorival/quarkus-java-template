package br.com.lorival;

import br.com.lorival.tasks.repositories.UserRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import java.util.List;
import org.openapi.quarkus.openapi_yml.api.DefaultApi;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;
import org.openapi.quarkus.openapi_yml.model.TaskResponse;

public class TasksResource implements DefaultApi {

  @Inject private UserRepository repository;
  @Inject private TaskMapper mapper;

  @Override
  public Uni<List<TaskResponse>> tasksGet() {
    return repository
        .findAll()
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(entity -> mapper.toResponse(entity))
        .collect()
        .asList();
  }

  @Override
  public Uni<TaskResponse> tasksPost(TaskRequest taskInput) {
    return repository.save(mapper.toTask(taskInput)).map(task -> mapper.toResponse(task));
  }
}
