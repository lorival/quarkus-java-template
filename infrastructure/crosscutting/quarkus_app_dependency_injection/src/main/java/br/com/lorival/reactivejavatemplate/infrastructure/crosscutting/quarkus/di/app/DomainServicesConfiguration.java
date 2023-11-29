package br.com.lorival.reactivejavatemplate.infrastructure.crosscutting.quarkus.di.app;

import br.com.lorival.reactivejavatemplate.domain.repositories.UserRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import br.com.lorival.reactivejavatemplate.domain.services.impl.TaskCompletionServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DomainServicesConfiguration {
  @Produces
  public TaskCompletionService createTaskCompleteService(UserRepository repository) {
    return new TaskCompletionServiceImpl(repository);
  }
}
