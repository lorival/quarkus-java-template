package br.com.lorival.reactivejavatemplate.app.usecases.impl;

import br.com.lorival.reactivejavatemplate.app.usecases.CreateTaskUseCase;
import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

  private final UserRepository repository;

  @Override
  public Uni<Task> create(String taskDetail) {
    return repository.insert(new Task(taskDetail));
  }
}
