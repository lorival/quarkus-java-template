package br.com.lorival.app.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

public interface GreetingsController {
  Uni<Response> getGreetingMessage();
}
