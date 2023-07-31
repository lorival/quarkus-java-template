package br.com.lorival.tasks.orm;

import br.com.lorival.tasks.orm.entities.TaskTable;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class TaskPanacheRepository implements PanacheRepositoryBase<TaskTable, UUID> {}
