package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.adapters;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.UserRepository;
import br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.orm.tasks.TaskDomainToTableMapper;
import br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.orm.tasks.TaskPanacheRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class TaskRepositoryAdapter implements UserRepository {

  private final TaskPanacheRepository panacheRepository;
  private final TaskDomainToTableMapper mapper;

  @Override
  @WithSession
  public Uni<Task> save(Task task) {
    return Panache.withTransaction(() -> panacheRepository.persist(mapper.toTable(task)))
        .map(mapper::toDomain);
  }

  @Override
  @WithSession
  public Uni<List<Task>> findAll() {
    return panacheRepository
        .listAll()
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(mapper::toDomain)
        .collect()
        .asList();
  }
}
