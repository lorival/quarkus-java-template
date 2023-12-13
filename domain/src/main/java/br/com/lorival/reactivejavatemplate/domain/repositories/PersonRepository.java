package br.com.lorival.reactivejavatemplate.domain.repositories;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface PersonRepository {

  Uni<Person> insert(Person person);

  Uni<Void> update(Person person);

  Uni<List<Person>> findAll(int page, int pageSize);

  Uni<Person> findByID(Long ID);
}
