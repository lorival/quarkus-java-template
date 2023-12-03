package br.com.lorival.reactivejavatemplate.domain.services.impl;

import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServicesConfiguration {
  @Bean
  public TaskCompletionService createTaskCompleteService(TaskRepository repository) {
    return new TaskCompletionServiceImpl(repository);
  }
}
