package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given().when().get("/greeting").then().statusCode(200).body(is("Hello"));
  }
}
