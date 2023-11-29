package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TaskDomainToTableMapper {
  TaskTable toTable(Task entity);

  Task toDomain(TaskTable table);
}
