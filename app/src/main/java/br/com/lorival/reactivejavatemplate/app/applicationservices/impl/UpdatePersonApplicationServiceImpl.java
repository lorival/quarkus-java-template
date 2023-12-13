package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.UpdatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.impl.exceptions.PersonNotFoundException;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdatePersonApplicationServiceImpl implements UpdatePersonApplicationService {

  private final PersonRepository repository;

  @Override
  public Uni<Void> update(long id, String name, int age) {
    return repository
        .findByID(id)
        .onItem()
        .ifNotNull()
        .transformToUni(
            existingPerson -> {
              existingPerson.setName(name);
              existingPerson.setAge(age);
              return repository.update(existingPerson);
            })
        .onItem()
        .ifNull()
        .failWith(() -> new PersonNotFoundException(id));
  }
}
