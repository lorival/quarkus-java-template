package br.com.lorival.reactivejavatemplate.app.usecases;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface GetTasksUseCase {
  Uni<List<Task>> get();
}
