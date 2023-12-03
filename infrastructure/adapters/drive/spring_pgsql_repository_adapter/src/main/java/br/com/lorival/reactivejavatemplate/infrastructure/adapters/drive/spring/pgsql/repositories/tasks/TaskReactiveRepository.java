package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.spring.pgsql.repositories.tasks;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskReactiveRepository extends ReactiveCrudRepository<TaskTable, Long> {}
