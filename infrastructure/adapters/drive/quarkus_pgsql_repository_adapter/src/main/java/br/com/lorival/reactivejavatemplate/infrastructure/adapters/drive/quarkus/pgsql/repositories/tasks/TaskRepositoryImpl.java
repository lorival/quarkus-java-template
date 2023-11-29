package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.tasks;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import br.com.lorival.reactivejavatemplate.domain.repositories.TaskRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

  private final TaskPanacheRepository panacheRepository;
  private final TaskDomainToTableMapper mapper;

  @Override
  @WithSession
  public Uni<Task> insert(Task task) {
    return Panache.withTransaction(() -> panacheRepository.persist(mapper.toTable(task)))
        .map(mapper::toDomain);
  }

  @Override
  @WithSession
  public Uni<Void> update(Task task) {
    return Panache.withTransaction(
            () ->
                panacheRepository.update(
                    "UPDATE TaskTable t SET t.detail = ?1, t.completed = ?2, t.completedAt = ?3 WHERE t.id = ?4",
                    task.getDetail(),
                    task.isCompleted(),
                    task.getCompletedAt(),
                    task.getId()))
        .onItem()
        .transformToUni(updatedRows -> Uni.createFrom().voidItem());
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

  @Override
  @WithSession
  public Uni<Task> findByID(Long ID) {
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
