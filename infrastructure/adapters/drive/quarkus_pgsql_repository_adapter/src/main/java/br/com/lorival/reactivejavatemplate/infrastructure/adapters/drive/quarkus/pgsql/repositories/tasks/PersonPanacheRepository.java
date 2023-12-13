package br.com.lorival.reactivejavatemplate.infrastructure.adapters.drive.quarkus.pgsql.repositories.tasks;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonPanacheRepository implements PanacheRepository<PersonTable> {}
