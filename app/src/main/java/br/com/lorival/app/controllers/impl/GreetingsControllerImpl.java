package br.com.lorival.app.controllers.impl;

import br.com.lorival.app.controllers.GreetingsController;
import io.smallrye.mutiny.Uni;

public class GreetingsControllerImpl implements GreetingsController {
  @Override
  public Uni<String> getGreetingMessage() {
    return Uni.createFrom().item("Hello");
  }
}
