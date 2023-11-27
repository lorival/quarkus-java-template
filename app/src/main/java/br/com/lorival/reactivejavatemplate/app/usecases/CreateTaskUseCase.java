package br.com.lorival.reactivejavatemplate.app.usecases;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;

public interface CreateTaskUseCase {
  Uni<Task> create(String taskDetail);
}
