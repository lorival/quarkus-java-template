package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.spring.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDomainToTableMapper {
  TaskTable toTable(Person entity);

  Person toDomain(TaskTable table);
}
