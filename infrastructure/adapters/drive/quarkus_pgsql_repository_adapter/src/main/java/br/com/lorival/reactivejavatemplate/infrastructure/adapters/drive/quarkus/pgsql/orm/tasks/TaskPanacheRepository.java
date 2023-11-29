package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.orm.tasks;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskPanacheRepository implements PanacheRepository<TaskTable> {}
