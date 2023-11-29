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
    task.setCompleted(entity.isCompleted());
    task.setCompletedAt(entity.getCompletedAt());
    return task;
  }

  public Task toDomain(TaskTable table) {
    var task = new Task(table.getDetail());
    task.setId(table.getId());
    task.setCreatedAt(table.getCreatedAt());
    task.setCompleted(table.isCompleted());
    task.setCompletedAt(table.getCompletedAt());
    return task;
  }
}
