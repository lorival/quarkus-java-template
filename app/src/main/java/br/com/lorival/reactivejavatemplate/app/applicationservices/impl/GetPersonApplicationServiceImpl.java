package br.com.lorival.reactivejavatemplate.app.applicationservices.impl;

import br.com.lorival.reactivejavatemplate.app.applicationservices.GetPersonApplicationService;
import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.smallrye.mutiny.Uni;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetPersonApplicationServiceImpl implements GetPersonApplicationService {

  private final PersonRepository repository;

  @Override
  public Uni<List<Person>> get(int page, int pageSize) {
    return repository.findAll(page, pageSize);
  }
}
