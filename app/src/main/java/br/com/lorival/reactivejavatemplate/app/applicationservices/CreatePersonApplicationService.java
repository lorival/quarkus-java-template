package br.com.lorival.reactivejavatemplate.app.applicationservices;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import io.smallrye.mutiny.Uni;

public interface CreatePersonApplicationService {
  Uni<Person> create(String name, int age);
}
