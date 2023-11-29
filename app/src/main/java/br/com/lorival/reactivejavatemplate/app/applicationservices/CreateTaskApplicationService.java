package br.com.lorival.reactivejavatemplate.app.applicationservices;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;

public interface CreateTaskApplicationService {
  Uni<Task> create(String taskDetail);
}
