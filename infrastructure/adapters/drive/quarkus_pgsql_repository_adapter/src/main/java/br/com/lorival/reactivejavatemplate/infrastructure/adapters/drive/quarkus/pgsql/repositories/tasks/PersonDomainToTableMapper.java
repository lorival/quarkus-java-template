package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PersonDomainToTableMapper {
  PersonTable toTable(Person entity);

  Person toDomain(PersonTable table);
}
