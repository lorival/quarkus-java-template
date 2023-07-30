package br.com.lorival.app.controllers;

import br.com.lorival.tasks.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface TaskController {
  Uni<List<Task>> get();

  Uni<Task> create(String taskDetail);
}
