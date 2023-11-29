package br.com.lorival.reactivejavatemplate.app.applicationservices;

import io.smallrye.mutiny.Uni;

public interface CompleteTaskApplicationService {
  Uni<Void> complete(Long taskID);
}
