package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.persons;

import static jakarta.ws.rs.core.Response.Status.*;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CreatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetPersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.UpdatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.impl.exceptions.PersonNotFoundException;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.PersonsApi;
import org.openapi.quarkus.openapi_yml.model.CreatePersonRequest;
import org.openapi.quarkus.openapi_yml.model.UpdatePersonRequest;

@RequiredArgsConstructor
public class PersonResource implements PersonsApi {

  private final CreatePersonApplicationService createPersonService;
  private final UpdatePersonApplicationService updatePersonService;
  private final GetPersonApplicationService getPersonService;
  private final PersonResponseMapper responseMapper;

  @Override
  public Uni<Response> personsGet(Integer page, Integer pageSize) {
    return getPersonService
        .get(page, pageSize)
        .onItem()
        .transformToMulti(list -> Multi.createFrom().iterable(list))
        .onItem()
        .transform(responseMapper::toResponse)
        .collect()
        .asList()
        .map(list -> Response.ok(list).build());
  }

  @Override
  public Uni<Response> personsPost(CreatePersonRequest request) {
    return createPersonService
        .create(request.getName(), request.getAge())
        .map(person -> Response.status(CREATED).entity(responseMapper.toResponse(person)).build());
  }

  @Override
  public Uni<Response> personsPut(UpdatePersonRequest request) {
    return updatePersonService
        .update(request.getId(), request.getName(), request.getAge())
        .onItem()
        .transform(person -> Response.status(NO_CONTENT).build())
        .onFailure(PersonNotFoundException.class)
        .recoverWithItem(() -> Response.status(NOT_FOUND).build());
  }
}
