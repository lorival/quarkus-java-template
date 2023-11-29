package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.greetings;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.GreetingsApi;

@RequiredArgsConstructor
public class GreetingsResource implements GreetingsApi {

  private final AppGreetingsApplicationService appGreetingsUseCase;

  @Override
  public Uni<Response> getGreetingMessage() {
    return appGreetingsUseCase
        .getGreetingMessage()
        .onItem()
        .transform(value -> Response.ok(value).build());
  }
}
