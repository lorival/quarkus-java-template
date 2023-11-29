package br.com.lorival.reactivejavatemplate.app.applicationservices;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface GetTasksApplicationService {
  Uni<List<Task>> get();
}
