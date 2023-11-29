package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import io.smallrye.mutiny.Uni;

class AppGreetingsApplicationServiceImpl implements AppGreetingsApplicationService {
  @Override
  public Uni<String> getGreetingMessage() {
    return Uni.createFrom().item("Hello");
  }
}
