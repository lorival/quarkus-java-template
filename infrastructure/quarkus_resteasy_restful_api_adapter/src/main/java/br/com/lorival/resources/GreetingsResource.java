package br.com.lorival.resources;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import org.openapi.quarkus.openapi_yml.api.GreetingsApi;

public class GreetingsResource implements GreetingsApi {

  @Override
  public Uni<Response> getGreetingMessage() {
    return Uni.createFrom().item(Response.ok("Hello").build());
  }
}