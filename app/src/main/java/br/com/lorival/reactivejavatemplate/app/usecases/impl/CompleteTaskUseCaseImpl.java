package br.com.lorival.reactivejavatemplate.app.usecases.impl;

import br.com.lorival.reactivejavatemplate.app.usecases.CompleteTaskUseCase;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompleteTaskUseCaseImpl implements CompleteTaskUseCase {

  private final TaskCompletionService service;

  @Override
  public Uni<Void> complete(Long taskID) {
    return service.completeTaskByID(taskID);
  }
}
