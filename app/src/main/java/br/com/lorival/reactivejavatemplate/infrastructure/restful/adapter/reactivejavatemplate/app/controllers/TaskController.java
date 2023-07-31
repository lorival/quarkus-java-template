package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.app.controllers;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface TaskController {
  Uni<List<Task>> get();

  Uni<Task> create(String taskDetail);
}
