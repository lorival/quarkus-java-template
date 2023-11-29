package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CompleteTaskApplicationService;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CompleteTaskApplicationServiceImpl implements CompleteTaskApplicationService {

  private final TaskCompletionService service;

  @Override
  public Uni<Void> complete(Long taskID) {
    return service.completeTaskByID(taskID);
  }
}
