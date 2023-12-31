package br.com.lorival.reactivejavatemplate.domain.services.impl;

import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import br.com.lorival.reactivejavatemplate.domain.services.TaskCompletionService;
import br.com.lorival.reactivejavatemplate.domain.services.exceptions.TaskNotExistException;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TaskCompletionServiceImpl implements TaskCompletionService {

  private final TaskRepository userRepository;

  @Override
  public Uni<Void> completeTaskByID(Long taskID) {
    return userRepository
        .findByID(taskID)
        .onItem()
        .transformToUni(
            task -> {
              if (task == null) {
                throw new TaskNotExistException(taskID);
              } else {
                task.complete();
                return userRepository.update(task).replaceWithVoid();
              }
            });
  }
}
