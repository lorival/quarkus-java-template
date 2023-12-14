package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.CreatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetPersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.UpdatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ApplicationServicesConfiguration {

  @Produces
  public CreatePersonApplicationService createTaskUseCase(PersonRepository repository) {
    return new CreatePersonApplicationServiceImpl(repository);
  }

  @Produces
  public GetPersonApplicationService getTaskUseCase(PersonRepository repository) {
    return new GetPersonApplicationServiceImpl(repository);
  }

  @Produces
  public UpdatePersonApplicationService updateTaskUseCase(PersonRepository repository) {
    return new UpdatePersonApplicationServiceImpl(repository);
  }

  @Produces
  public AppGreetingsApplicationService createGreetingsController() {
    return new AppGreetingsApplicationServiceImpl();
  }
}
