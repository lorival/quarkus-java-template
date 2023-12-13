package br.com.lorival.reactivejavatemplate.app.applicationservices;

import br.com.lorival.reactivejavatemplate.domain.entities.Person;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface GetPersonApplicationService {
  Uni<List<Person>> get(int page, int pageSize);
}
