package br.com.lorival.reactivejavatemplate.domain.repositories;

import br.com.lorival.reactivejavatemplate.domain.entities.Task;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface UserRepository {

  Uni<Task> insert(Task task);

  Uni<Void> update(Task task);

  Uni<List<Task>> findAll();

  Uni<Task> findByID(Long ID);
}
