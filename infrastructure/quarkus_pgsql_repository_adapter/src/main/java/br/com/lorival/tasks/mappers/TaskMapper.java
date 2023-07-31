package br.com.lorival.tasks.mappers;

import br.com.lorival.tasks.entities.Task;
import br.com.lorival.tasks.orm.entities.TaskTable;
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
    var task = new br.com.lorival.tasks.entities.Task(entity.getDetail());
    task.setId(entity.getId());
    task.setCreatedAt(entity.getCreatedAt());
    task.setDone(entity.isDone());
    return task;
  }
}
