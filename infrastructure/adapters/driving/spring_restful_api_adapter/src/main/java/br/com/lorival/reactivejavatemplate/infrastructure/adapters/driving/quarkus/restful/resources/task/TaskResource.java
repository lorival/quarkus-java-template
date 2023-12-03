package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.task;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CompleteTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.CreateTaskApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetTasksApplicationService;
import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.services.exceptions.TaskNotExistException;
import io.smallrye.mutiny.converters.uni.UniReactorConverters;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.openapi.spring.openapi_yml.api.TasksApi;
import org.openapi.spring.openapi_yml.model.TaskRequest;
import org.openapi.spring.openapi_yml.model.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class TaskResource implements TasksApi {

  private final CreateTaskApplicationService createTaskService;
  private final GetTasksApplicationService getTasksService;
  private final CompleteTaskApplicationService completeTaskService;
  private final TaskResponseMapper responseMapper;

  @Override
  public Mono<ResponseEntity<Flux<TaskResponse>>> tasksGet(ServerWebExchange exchange) {

    Mono<List<Task>> taskListMono =
        getTasksService.get().convert().with(UniReactorConverters.toMono());
    Flux<Task> taskFlux = taskListMono.flatMapMany(Flux::fromIterable);
    Flux<TaskResponse> taskResponseFlux = taskFlux.map(responseMapper::toResponse);
    return taskResponseFlux.collectList().map(list -> ResponseEntity.ok(Flux.fromIterable(list)));
  }

  @Override
  public Mono<ResponseEntity<TaskResponse>> tasksPost(
      Mono<TaskRequest> taskRequest, ServerWebExchange exchange) {

    return taskRequest.flatMap(
        request ->
            createTaskService
                .create(request.getDetail())
                .convert()
                .with(UniReactorConverters.toMono())
                .map(
                    task ->
                        ResponseEntity.status(HttpStatus.CREATED)
                            .body(responseMapper.toResponse(task))));
  }

  @Override
  public Mono<ResponseEntity<Void>> updateTaskAsCompleted(Long taskID, ServerWebExchange exchange) {
    return completeTaskService
        .complete(taskID)
        .convert()
        .with(UniReactorConverters.toMono())
        .then(Mono.defer(() -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
        .onErrorResume(
            TaskNotExistException.class,
            ex -> Mono.just(new ResponseEntity<Void>(HttpStatus.NOT_FOUND)));
  }
}
