package br.com.lorival.reactivejavatemplate.app.applicationservices.impl.exceptions;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(long personID) {
    super("Person not found with id: " + personID);
  }
}
