package br.com.lorival.reactivejavatemplate.app.usecases;

import io.smallrye.mutiny.Uni;

public interface AppGreetingsUseCase {
  Uni<String> getGreetingMessage();
}
