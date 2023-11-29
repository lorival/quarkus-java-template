package br.com.lorival.reactivejavatemplate.domain.services.exceptions;

public class TaskNotExistException extends RuntimeException {

  public TaskNotExistException(Long taskID) {
    super("Task " + taskID + " doesn't exist.");
  }
}
