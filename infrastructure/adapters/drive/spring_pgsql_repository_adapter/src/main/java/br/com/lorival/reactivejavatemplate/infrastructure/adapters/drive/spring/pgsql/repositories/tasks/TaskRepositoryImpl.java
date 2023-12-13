package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.spring.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import br.com.lorival.reactivejavatemplate.domain.repositories.PersonRepository;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TaskRepositoryImpl implements PersonRepository {

  private final TaskReactiveRepository reactiveRepository;
  private final TaskDomainToTableMapper mapper;

  @Override
  public Uni<Person> insert(Person task) {
    return Uni.createFrom()
        .completionStage(reactiveRepository.save(mapper.toTable(task)).toFuture())
        .map(mapper::toDomain);
  }

  @Override
  public Uni<Void> update(Person task) {
    return Uni.createFrom()
        .completionStage(reactiveRepository.save(mapper.toTable(task)).then().toFuture());
  }

  @Override
  public Uni<List<Person>> findAll(int page, int pageSize) {
    return Uni.createFrom()
        .completionStage(reactiveRepository.findAll().collectList().toFuture())
        .map(list -> list.stream().map(mapper::toDomain).collect(Collectors.toList()));
  }

  @Override
  public Uni<Person> findByID(Long ID) {
    return Uni.createFrom()
        .completionStage(reactiveRepository.findById(ID).toFuture())
        .map(mapper::toDomain);
  }
}
