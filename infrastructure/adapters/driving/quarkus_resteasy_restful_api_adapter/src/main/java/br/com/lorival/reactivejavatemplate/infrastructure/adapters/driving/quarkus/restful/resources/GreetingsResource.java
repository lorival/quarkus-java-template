package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources;

import br.com.lorival.reactivejavatemplate.app.usecases.AppGreetingsUseCase;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.GreetingsApi;

@RequiredArgsConstructor
public class GreetingsResource implements GreetingsApi {

  private final AppGreetingsUseCase appGreetingsUseCase;

  @Override
  public Uni<Response> getGreetingMessage() {
    return appGreetingsUseCase
        .getGreetingMessage()
        .onItem()
        .transform(value -> Response.ok(value).build());
  }
}
