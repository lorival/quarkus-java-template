package br.com.lorival.reactivejavatemplate.app.usecases.impl;

import br.com.lorival.reactivejavatemplate.app.usecases.GetTasksUseCase;
import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.UserRepository;
import io.smallrye.mutiny.Uni;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTasksUseCaseImpl implements GetTasksUseCase {

  private final UserRepository repository;

  @Override
  public Uni<List<Task>> get() {
    return repository.findAll();
  }
}
