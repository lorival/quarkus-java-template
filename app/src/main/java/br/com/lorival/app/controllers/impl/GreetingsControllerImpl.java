package br.com.lorival.app.controllers.impl;

import br.com.lorival.app.controllers.GreetingsController;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public class GreetingsControllerImpl implements GreetingsController {
  @Override
  public Uni<Response> getGreetingMessage() {
    return Uni.createFrom().item(Response.ok("Hello").build());
  }
}
