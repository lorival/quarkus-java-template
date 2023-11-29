package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CreateTaskApplicationService;
import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionNotificationService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CreateTaskApplicationServiceImpl implements CreateTaskApplicationService {

  private final TaskRepository repository;
  private final TaskCompletionNotificationService notificationService;

  @Override
  public Uni<Task> create(String taskDetail) {
    return repository
        .insert(new Task(taskDetail))
        .onItem()
        .transformToUni(
            task ->
                notificationService
                    .notify(task)
                    .onItem()
                    .transformToUni(ignored -> Uni.createFrom().item(task)));
  }
}
