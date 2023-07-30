package br.com.lorival.controllers;

import br.com.lorival.app.controllers.GreetingsController;
import br.com.lorival.app.controllers.TaskController;
import br.com.lorival.app.controllers.impl.GreetingsControllerImpl;
import br.com.lorival.app.controllers.impl.TaskControllerImpl;
import br.com.lorival.tasks.repositories.UserRepository;
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
