package br.com.lorival.reactivejavatemplate.app.usecases;

import io.smallrye.mutiny.Uni;

public interface CompleteTaskUseCase {
  Uni<Void> complete(Long taskID);
}
