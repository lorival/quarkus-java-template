package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.orm.tasks;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class TaskPanacheRepository implements PanacheRepositoryBase<TaskTable, UUID> {}
