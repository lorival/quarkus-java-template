package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.greetings;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import io.smallrye.mutiny.converters.uni.UniReactorConverters;
import lombok.RequiredArgsConstructor;
import org.openapi.spring.openapi_yml.api.GreetingApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GreetingsResource implements GreetingApi {

  private final AppGreetingsApplicationService appGreetingsService;

  @Override
  public Mono<ResponseEntity<String>> getGreetingMessage(ServerWebExchange exchange) {
    Mono<String> monoGreeting =
        appGreetingsService.getGreetingMessage().convert().with(UniReactorConverters.toMono());
    return monoGreeting.map(ResponseEntity::ok);
  }
}
