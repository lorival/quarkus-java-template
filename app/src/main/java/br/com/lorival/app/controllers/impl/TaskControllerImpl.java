package br.com.lorival.app.controllers.impl;

import br.com.lorival.app.controllers.TaskController;
import br.com.lorival.tasks.entities.Task;
import br.com.lorival.tasks.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import java.util.List;

public class TaskControllerImpl implements TaskController {

  private final UserRepository repository;

  @Inject
  public TaskControllerImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public Uni<List<Task>> get() {
    return repository.findAll();
  }

  @Override
  public Uni<Task> create(String taskDetail) {
    return repository.save(new Task(taskDetail));
  }
}
