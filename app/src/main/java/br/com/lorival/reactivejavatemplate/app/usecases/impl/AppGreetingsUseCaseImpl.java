package br.com.lorival.reactivejavatemplate.app.usecases.impl;

import br.com.lorival.reactivejavatemplate.app.usecases.AppGreetingsUseCase;
import io.smallrye.mutiny.Uni;

public class AppGreetingsUseCaseImpl implements AppGreetingsUseCase {
  @Override
  public Uni<String> getGreetingMessage() {
    return Uni.createFrom().item("Hello");
  }
}
