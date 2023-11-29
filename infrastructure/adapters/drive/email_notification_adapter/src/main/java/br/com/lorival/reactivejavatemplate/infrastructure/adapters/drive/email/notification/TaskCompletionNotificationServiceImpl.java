package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.email.notification;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionNotificationService;
import io.smallrye.mutiny.Uni;

class TaskCompletionNotificationServiceImpl implements TaskCompletionNotificationService {

  @Override
  public Uni<Void> notify(Task task) {
    // TODO: This is just an example, here we could implement an email notification for the task.
    return Uni.createFrom().voidItem();
  }
}
