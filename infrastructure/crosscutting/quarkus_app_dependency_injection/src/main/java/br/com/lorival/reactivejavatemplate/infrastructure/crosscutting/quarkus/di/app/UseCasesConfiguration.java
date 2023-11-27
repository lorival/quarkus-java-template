package br.com.lorival.reactivejavatemplate.infrastructure.crosscutting.quarkus.di.app;

import br.com.lorival.reactivejavatemplate.app.usecases.AppGreetingsUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.CreateTaskUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.GetTasksUseCase;
import br.com.lorival.reactivejavatemplate.app.usecases.impl.AppGreetingsUseCaseImpl;
import br.com.lorival.reactivejavatemplate.app.usecases.impl.CreateTaskUseCaseImpl;
import br.com.lorival.reactivejavatemplate.app.usecases.impl.GetTasksUseCaseImpl;
import br.com.lorival.reactivejavatemplate.domain.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UseCasesConfiguration {
  @Produces
  public CreateTaskUseCase createTaskUseCase(UserRepository repository) {
    return new CreateTaskUseCaseImpl(repository);
  }

  @Produces
  public GetTasksUseCase getTaskUseCase(UserRepository repository) {
    return new GetTasksUseCaseImpl(repository);
  }

  @Produces
  public AppGreetingsUseCase createGreetingsController() {
    return new AppGreetingsUseCaseImpl();
  }
}
