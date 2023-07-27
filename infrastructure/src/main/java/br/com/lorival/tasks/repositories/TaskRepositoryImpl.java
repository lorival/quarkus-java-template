package br.com.lorival.tasks.repositories;

import br.com.lorival.tasks.entities.Task;
import br.com.lorival.tasks.orm.TaskPanacheRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class TaskRepositoryImpl implements UserRepository {

  private final TaskPanacheRepository panacheRepository;

  @Override
  @WithSession
  public Uni<Task> save(Task task) {
    return Panache.withTransaction(() -> panacheRepository.persist(task));
  }

  public Uni<Task> findById(UUID uuid) {
    return panacheRepository.findById(uuid);
  }

  @Override
  @WithSession
  public Uni<List<Task>> findAll() {
    return panacheRepository.listAll();
  }
}
