package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers;

import io.smallrye.mutiny.Uni;

public interface GreetingsController {
  Uni<String> getGreetingMessage();
}
