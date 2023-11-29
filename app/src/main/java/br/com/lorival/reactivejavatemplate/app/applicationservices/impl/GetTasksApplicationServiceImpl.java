package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.GetTasksApplicationService;
import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import io.smallrye.mutiny.Uni;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetTasksApplicationServiceImpl implements GetTasksApplicationService {

  private final TaskRepository repository;

  @Override
  public Uni<List<Task>> get() {
    return repository.findAll();
  }
}
