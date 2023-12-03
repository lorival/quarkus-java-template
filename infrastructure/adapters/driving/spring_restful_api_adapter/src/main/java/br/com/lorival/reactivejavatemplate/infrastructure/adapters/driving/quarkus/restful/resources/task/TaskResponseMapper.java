package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.task;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapi.spring.openapi_yml.model.TaskResponse;

@Mapper(componentModel = "spring")
public interface TaskResponseMapper {

  @Mapping(target = "done", source = "completed")
  @Mapping(
      target = "createdAt",
      source = "createdAt",
      qualifiedByName = "localDateTimeToOffsetDateTime")
  TaskResponse toResponse(Task entity);

  @Named("localDateTimeToOffsetDateTime")
  default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
    return localDateTime == null ? null : localDateTime.atOffset(ZoneOffset.UTC);
  }
}
