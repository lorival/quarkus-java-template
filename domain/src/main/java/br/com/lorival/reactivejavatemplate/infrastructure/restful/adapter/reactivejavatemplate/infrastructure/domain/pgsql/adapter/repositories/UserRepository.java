package br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.repositories;

import br.com.lorival.reactivejavatemplate.infrastructure.restful.adapter.reactivejavatemplate.infrastructure.domain.pgsql.adapter.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.UUID;

public interface UserRepository {

  Uni<Task> save(Task task);

  Uni<Task> findById(UUID uuid);

  Uni<List<Task>> findAll();
}
