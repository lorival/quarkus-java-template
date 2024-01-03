package br.com.lorival.reactivejavatemplate.load.tests

import br.com.lorival.reactivejavatemplate.load.tests.PerfTestConfig._
import io.gatling.core.Predef.{constantUsersPerSec, global, scenario, _}
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class GetPersonSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)

  val getPersons: ScenarioBuilder = scenario("Get Person")
    .exec(http("Request - GET /persons")
      .get("/persons")
      .queryParam("page", "0")
      .queryParam("pageSize", "10")
      .check(status.is(200))
    )

  setUp(
    getPersons.inject(
      constantUsersPerSec(500).during(10 minutes)
    ).protocols(httpConf)
  )

}