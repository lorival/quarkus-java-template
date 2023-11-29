package br.com.lorival.reactivejavatemplate.domain.services.impl;

import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DomainServicesConfiguration {
  @Produces
  public TaskCompletionService createTaskCompleteService(TaskRepository repository) {
    return new TaskCompletionServiceImpl(repository);
  }
}
