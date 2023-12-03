package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.spring.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDomainToTableMapper {
  TaskTable toTable(Task entity);

  Task toDomain(TaskTable table);
}
