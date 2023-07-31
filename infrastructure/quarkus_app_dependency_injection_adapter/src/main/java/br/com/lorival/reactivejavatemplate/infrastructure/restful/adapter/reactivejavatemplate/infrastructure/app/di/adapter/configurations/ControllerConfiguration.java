package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.app.di.adapter.configurations;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.GreetingsController;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.TaskController;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.impl.GreetingsControllerImpl;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers.impl.TaskControllerImpl;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ControllerConfiguration {
  @Produces
  public TaskController createTaskController(UserRepository repository) {
    return new TaskControllerImpl(repository);
  }

  @Produces
  public GreetingsController createGreetingsController() {
    return new GreetingsControllerImpl();
  }
}
