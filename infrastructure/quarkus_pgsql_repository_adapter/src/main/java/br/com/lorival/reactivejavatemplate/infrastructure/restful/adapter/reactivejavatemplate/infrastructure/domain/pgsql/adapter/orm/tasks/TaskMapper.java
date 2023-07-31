package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.orm.tasks;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskMapper {

  public TaskTable toORM(Task entity) {
    var task = new TaskTable();
    task.setId(entity.getId());
    task.setDetail(entity.getDetail());
    task.setCreatedAt(entity.getCreatedAt());
    task.setDone(entity.isDone());
    return task;
  }

  public Task toEntity(TaskTable entity) {
    var task = new Task(entity.getDetail());
    task.setId(entity.getId());
    task.setCreatedAt(entity.getCreatedAt());
    task.setDone(entity.isDone());
    return task;
  }
}
