package br.com.lorival.reactivejavatemplate.app.applicationservices;

import io.smallrye.mutiny.Uni;

public interface UpdatePersonApplicationService {
  Uni<Void> update(long id, String name, int age);
}
