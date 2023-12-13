package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.task;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import org.mapstruct.Mapper;
import org.openapi.spring.openapi_yml.model.PersonResponse;

@Mapper(componentModel = "spring")
public interface TaskResponseMapper {

  PersonResponse toResponse(Person entity);
}
