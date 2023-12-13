package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CreatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CreatePersonApplicationServiceImpl implements CreatePersonApplicationService {

  private final PersonRepository repository;

  @Override
  public Uni<Person> create(String name, int age) {
    var person = new Person(name);
    person.setAge(age);
    return repository.insert(person);
  }
}
