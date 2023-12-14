package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources.persons;

import static jakarta.ws.rs.core.Response.Status.*;

import br.com.lorival.reactivejavatemplate.app.applicationservices.CreatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.GetPersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.UpdatePersonApplicationService;
import br.com.lorival.reactivejavatemplate.app.applicationservices.impl.exceptions.PersonNotFoundException;
import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.openapi.quarkus.openapi_yml.api.PersonsApi;
import org.openapi.quarkus.openapi_yml.model.CreatePersonRequest;
import org.openapi.quarkus.openapi_yml.model.PersonResponse;
import org.openapi.quarkus.openapi_yml.model.UpdatePersonRequest;

@RequiredArgsConstructor
public class PersonResource implements PersonsApi {

  private final CreatePersonApplicationService createPersonService;
  private final UpdatePersonApplicationService updatePersonService;
  private final GetPersonApplicationService getPersonService;
  private final PersonResponseMapper responseMapper;

  @Override
  public Response personsGet(Integer page, Integer pageSize) {
    var list =
        getPersonService
            .get(page, pageSize)
            .onItem()
            .transformToMulti(Multi.createFrom()::iterable)
            .onItem()
            .transform(responseMapper::toResponse)
            .collect()
            .asList()
            .await()
            .indefinitely();

    return Response.ok(list).build();
  }

  @Override
  public Response personsPost(CreatePersonRequest request) {
    PersonResponse personResponse =
        createPersonService
            .create(request.getName(), request.getAge())
            .onItem()
            .transform(responseMapper::toResponse)
            .await()
            .indefinitely();

    return Response.status(Response.Status.CREATED).entity(personResponse).build();
  }

  @Override
  public Response personsPut(UpdatePersonRequest request) {
    try {
      updatePersonService
          .update(request.getId(), request.getName(), request.getAge())
          .await()
          .indefinitely();
      return Response.status(Response.Status.NO_CONTENT).build();
    } catch (PersonNotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }
}
