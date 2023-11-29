package br.com.lorival.reactivejavatemplate.domain.services;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;

public interface TaskCompletionNotificationService {

  Uni<Void> notify(Task task);
}
