package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.openapi_yml.model.CreatePersonRequest;

@QuarkusTest
public class TaskResourceTest {

  @Test
  public void testCreateTaskEndpoint() {
    CreatePersonRequest taskRequest = new CreatePersonRequest();
    taskRequest.setName("Name");

    given()
        .contentType(ContentType.JSON)
        .body(taskRequest)
        .when()
        .post("/tasks")
        .then()
        .statusCode(201)
        .contentType(ContentType.JSON)
        .body("detail", equalTo("Test task"))
        .body("done", is(false))
        .body("createdAt", is(not(emptyString())))
        .body("id", greaterThan(0));
  }

  @Test
  public void testListTasksEndpoint() {
    given()
        .when()
        .get("/tasks")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("size()", greaterThanOrEqualTo(0));
  }
}
