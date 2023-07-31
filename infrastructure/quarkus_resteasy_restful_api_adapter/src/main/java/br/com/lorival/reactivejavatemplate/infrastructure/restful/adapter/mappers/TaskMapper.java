package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.mappers;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.ZoneOffset;
import org.openapi.quarkus.openapi_yml.model.TaskResponse;

@ApplicationScoped
public class TaskMapper {

  public TaskResponse toResponse(Task entity) {
    var task = new TaskResponse();
    task.setId(entity.getId());
    task.setDetail(entity.getDetail());
    task.setCreatedAt(entity.getCreatedAt().atOffset(ZoneOffset.UTC));
    task.setDone(entity.isDone());
    return task;
  }
}
