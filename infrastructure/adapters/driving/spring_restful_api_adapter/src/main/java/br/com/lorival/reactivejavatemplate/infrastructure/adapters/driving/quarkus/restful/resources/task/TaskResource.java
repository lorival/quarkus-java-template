package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.task;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CreatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetPersonApplicationService;
import lombok.RequiredArgsConstructor;
import org.openapi.spring.openapi_yml.api.PersonsApi;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TaskResource implements PersonsApi {

  private final CreatePersonApplicationService createTaskService;
  private final GetPersonApplicationService getTasksService;
  private final TaskResponseMapper responseMapper;
}
