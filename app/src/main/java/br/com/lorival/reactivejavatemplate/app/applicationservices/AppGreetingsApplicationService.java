package br.com.lorival.reactivejavatemplate.app.applicationservices;

import io.smallrye.mutiny.Uni;

public interface AppGreetingsApplicationService {
  Uni<String> getGreetingMessage();
}
