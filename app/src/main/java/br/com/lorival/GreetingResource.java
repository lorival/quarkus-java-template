package br.com.lorival;

import io.smallrye.mutiny.Uni;
import org.openapi.quarkus.openapi_yml.api.GreetingsApi;

public class GreetingResource implements GreetingsApi {

  @Override
  public Uni<String> getGreetingMessage() {
    return Uni.createFrom().item("Hello");
  }
}
