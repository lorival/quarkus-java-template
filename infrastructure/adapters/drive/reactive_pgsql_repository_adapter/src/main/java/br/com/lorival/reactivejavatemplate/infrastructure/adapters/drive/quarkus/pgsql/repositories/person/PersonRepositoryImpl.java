package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.person;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class PersonRepositoryImpl implements PersonRepository {

  private final PersonPanacheRepository panacheRepository;
  private final PersonDomainToTableMapper mapper;

  @Override
  @WithSession
  public Uni<Person> insert(Person task) {
    return Panache.withTransaction(() -> panacheRepository.persist(mapper.toTable(task)))
        .map(mapper::toDomain);
  }

  @Override
  @WithSession
  public Uni<Person> update(Person person) {
    return Panache.withTransaction(
            () ->
                panacheRepository.update(
                    "UPDATE PersonTable t SET t.name = ?1, t.age = ?2 WHERE t.id = ?3",
                    person.getName(),
                    person.getAge(),
                    person.getId()))
        .onItem()
        .transformToUni(updatedRows -> Uni.createFrom().item(person));
  }

  @Override
  @WithSession
  public Uni<List<Person>> findAll(int page, int pageSize) {
    return panacheRepository
        .findAll()
        .page(Page.of(page, pageSize))
        .list()
        .onItem()
        .transformToMulti(Multi.createFrom()::iterable)
        .onItem()
        .transform(mapper::toDomain)
        .collect()
        .asList();
  }

  @Override
  @WithSession
  public Uni<Person> findByID(Long ID) {
    return panacheRepository
        .findById(ID)
        .onItem()
        .ifNotNull()
        .transform(mapper::toDomain)
        .onItem()
        .ifNull()
        .switchTo(Uni.createFrom().nullItem());
  }
}
