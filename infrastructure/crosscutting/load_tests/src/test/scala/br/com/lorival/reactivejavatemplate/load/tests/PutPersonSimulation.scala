package br.com.lorival.reactivejavatemplate.load.tests

import br.com.lorival.reactivejavatemplate.load.tests.PerfTestConfig._
import io.gatling.core.Predef.{constantUsersPerSec, global, scenario, _}
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class PutPersonSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)

  val updatePerson: ScenarioBuilder = scenario("Update Person")
    .exec(http("Request - PUT /persons")
      .put("/persons")
      .body(StringBody("""{"id": 1, "name": "Teste Alterado", "age": 31}""")).asJson
      .check(status.is(404))
    )

  setUp(
    updatePerson.inject(
      constantUsersPerSec(500).during(10 minutes)
    ).protocols(httpConf)
  )
}