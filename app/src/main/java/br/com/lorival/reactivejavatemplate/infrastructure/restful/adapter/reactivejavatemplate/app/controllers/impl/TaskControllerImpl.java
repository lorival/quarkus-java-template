package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.impl;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.TaskController;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

  private final UserRepository repository;

  @Override
  public Uni<List<Task>> get() {
    return repository.findAll();
  }

  @Override
  public Uni<Task> create(String taskDetail) {
    return repository.save(new Task(taskDetail));
  }
}
