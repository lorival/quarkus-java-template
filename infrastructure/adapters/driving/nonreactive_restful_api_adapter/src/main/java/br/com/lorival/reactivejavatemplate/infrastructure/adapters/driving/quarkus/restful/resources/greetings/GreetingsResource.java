package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.greetings;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.HelloWorldApi;

@RequiredArgsConstructor
public class GreetingsResource implements HelloWorldApi {

  private final AppGreetingsApplicationService appGreetingsService;

  @Override
  public Response helloWorldGet() {
    return Response.ok(appGreetingsService.getGreetingMessage().await().indefinitely()).build();
  }
}
