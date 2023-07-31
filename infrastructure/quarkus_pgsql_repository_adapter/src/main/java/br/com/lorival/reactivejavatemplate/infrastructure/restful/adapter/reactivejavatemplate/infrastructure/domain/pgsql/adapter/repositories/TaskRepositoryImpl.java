package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.repositories;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.orm.tasks.TaskMapper;
import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.orm.tasks.TaskPanacheRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class TaskRepositoryImpl implements UserRepository {

  private final TaskPanacheRepository panacheRepository;
  private final TaskMapper mapper;

  @Override
  @WithSession
  public Uni<Task> save(Task task) {
    return Panache.withTransaction(() -> panacheRepository.persist(mapper.toORM(task)))
        .map(task2 -> mapper.toEntity(task2));
  }

  public Uni<Task> findById(UUID uuid) {
    return panacheRepository.findById(uuid).map(task -> mapper.toEntity(task));
  }

  @Override
  @WithSession
  public Uni<List<Task>> findAll() {
    return panacheRepository
        .listAll()
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(entity -> mapper.toEntity(entity))
        .collect()
        .asList();
  }
}
