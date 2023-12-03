package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.AppGreetingsApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.CompleteTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.CreateTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetTasksApplicationService;
import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionNotificationService;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ApplicationServicesConfiguration {

  @Produces
  public CreateTaskApplicationService createTaskUseCase(
      TaskRepository repository, TaskCompletionNotificationService notificationService) {
    return new CreateTaskApplicationServiceImpl(repository, notificationService);
  }

  @Produces
  public CompleteTaskApplicationService createCompleteTaskUseCase(TaskCompletionService service) {
    return new CompleteTaskApplicationServiceImpl(service);
  }

  @Produces
  public GetTasksApplicationService getTaskUseCase(TaskRepository repository) {
    return new GetTasksApplicationServiceImpl(repository);
  }

  @Produces
  public AppGreetingsApplicationService createGreetingsController() {
    return new AppGreetingsApplicationServiceImpl();
  }
}
