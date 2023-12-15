package br.com.lorival.reactivejavatemplate.load.tests

import br.com.lorival.reactivejavatemplate.load.tests.PerfTestConfig._
import io.gatling.core.Predef.{constantUsersPerSec, global, scenario, _}
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class PostPersonSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)
  val getHelloWorld: ScenarioBuilder = scenario("Create Person")
    .exec(http("Request - POST /persons")
      .post("/persons")
      .body(StringBody("""{"name": "Teste", "age": 30}""")).asJson
      .check(status.is(201))
    )

  setUp(getHelloWorld.inject(
    constantUsersPerSec(requestPerSecond) during (durationMin minutes))
    .protocols(httpConf))
    .assertions(
      global.responseTime.max.lt(maxResponseTimeMs),
      global.responseTime.mean.lt(meanResponseTimeMs),
      global.responseTime.percentile3.lt(p95ResponseTimeMs),
      global.successfulRequests.percent.gt(95)
    )
}