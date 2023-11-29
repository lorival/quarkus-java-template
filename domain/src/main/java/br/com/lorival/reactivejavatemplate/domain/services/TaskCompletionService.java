package br.com.lorival.reactivejavatemplate.domain.services;

import io.smallrye.mutiny.Uni;

public interface TaskCompletionService {

  Uni<Void> completeTaskByID(Long taskID);
}
