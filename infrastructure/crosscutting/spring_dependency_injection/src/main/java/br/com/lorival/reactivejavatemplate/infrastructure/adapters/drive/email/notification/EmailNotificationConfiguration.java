package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.email.notification;

import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailNotificationConfiguration {
  @Bean
  public TaskCompletionNotificationService createTaskCompletionNotificationService() {
    return new TaskCompletionNotificationServiceImpl();
  }
}
