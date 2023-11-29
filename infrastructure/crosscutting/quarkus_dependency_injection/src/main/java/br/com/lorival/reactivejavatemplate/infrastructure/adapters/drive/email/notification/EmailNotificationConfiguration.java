package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.email.notification;

import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionNotificationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class EmailNotificationConfiguration {
  @Produces
  public TaskCompletionNotificationService createTaskCompleteService() {
    return new TaskCompletionNotificationServiceImpl();
  }
}
