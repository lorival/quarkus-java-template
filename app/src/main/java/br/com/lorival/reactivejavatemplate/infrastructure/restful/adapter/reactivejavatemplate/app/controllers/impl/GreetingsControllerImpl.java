package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.impl;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.GreetingsController;
import io.smallrye.mutiny.Uni;

public class GreetingsControllerImpl implements GreetingsController {
  @Override
  public Uni<String> getGreetingMessage() {
    return Uni.createFrom().item("Hello");
  }
}
