package br.com.lorival;

import br.com.lorival.tasks.entities.Task;
import jakarta.enterprise.context.ApplicationScoped;
import org.openapi.quarkus.openapi_yml.model.TaskRequest;
import org.openapi.quarkus.openapi_yml.model.TaskResponse;

@ApplicationScoped
public class TaskMapper {

  public TaskResponse toResponse(Task entity) {
    var task = new TaskResponse();
    // task.setId(entity.getId());
    task.setDetail(entity.getDetail());
    // task.setCreatedAt(entity.getCreatedAt());
    // task.setDone(entity.isDone());
    return task;
  }

  public Task toTask(TaskRequest entity) {
    var task = new Task();
    // task.setId(entity.getId());
    task.setDetail(entity.getDetail());
    // task.setCreatedAt(entity.getCreatedAt());
    // task.setDone(entity.isDone());
    return task;
  }
}
