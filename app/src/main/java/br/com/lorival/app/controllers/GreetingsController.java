package br.com.lorival.app.controllers;

import io.smallrye.mutiny.Uni;

public interface GreetingsController {
  Uni<String> getGreetingMessage();
}
