package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.persons;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import org.mapstruct.Mapper;
import org.openapi.quarkus.openapi_yml.model.PersonResponse;

@Mapper(componentModel = "cdi")
public interface PersonResponseMapper {

  PersonResponse toResponse(Person entity);
}
