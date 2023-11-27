package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.orm.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskDomainToTableMapper {

  public TaskTable toTable(Task entity) {
    var task = new TaskTable();
    task.setId(entity.getId());
    task.setDetail(entity.getDetail());
    task.setCreatedAt(entity.getCreatedAt());
    task.setDone(entity.isDone());
    return task;
  }

  public Task toDomain(TaskTable entity) {
    var task = new Task(entity.getDetail());
    task.setId(entity.getId());
    task.setCreatedAt(entity.getCreatedAt());
    task.setDone(entity.isDone());
    return task;
  }
}
