package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.person;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
@Transactional
public class PersonRepositoryImpl implements PersonRepository {

  private final PersonPanacheRepository panacheRepository;
  private final PersonDomainToTableMapper mapper;

  @Override
  public Uni<Person> insert(Person person) {
    return Uni.createFrom()
        .item(
            () -> {
              PersonTable personTable = mapper.toTable(person);
              panacheRepository.persist(personTable);
              return mapper.toDomain(personTable);
            });
  }

  @Override
  public Uni<Person> update(Person person) {
    return Uni.createFrom()
        .item(
            () -> {
              panacheRepository.update(
                  "UPDATE PersonTable t SET t.name = ?1, t.age = ?2 WHERE t.id = ?3",
                  person.getName(),
                  person.getAge(),
                  person.getId());
              return person;
            });
  }

  @Override
  public Uni<List<Person>> findAll(int page, int pageSize) {
    return Uni.createFrom()
        .item(
            () -> {
              return panacheRepository.findAll().page(Page.of(page, pageSize)).list().stream()
                  .map(mapper::toDomain)
                  .collect(Collectors.toList());
            });
  }

  @Override
  public Uni<Person> findByID(Long ID) {
    return Uni.createFrom()
        .item(
            () -> {
              PersonTable personTable = panacheRepository.findById(ID);
              if (personTable != null) {
                return mapper.toDomain(personTable);
              } else {
                return null;
              }
            });
  }
}
