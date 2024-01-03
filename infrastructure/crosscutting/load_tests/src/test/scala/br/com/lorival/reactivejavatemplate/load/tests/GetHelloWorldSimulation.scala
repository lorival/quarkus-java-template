package br.com.lorival.reactivejavatemplate.load.tests

import PerfTestConfig._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.protocol.HttpProtocolBuilder
import br.com.lorival.reactivejavatemplate.load.tests.PerfTestConfig.{baseUrl, durationMin, maxResponseTimeMs, meanResponseTimeMs, p95ResponseTimeMs}
import io.gatling.core.Predef.{constantUsersPerSec, global, scenario, _}
import io.gatling.http.Predef.{http, status, _}

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.language.postfixOps

class GetHelloWorldSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)

  val getHelloWorld: ScenarioBuilder = scenario("Greetings")
    .exec(http("Request - GET /hello-world")
      .get("/hello-world")
      .check(status.is(200))
    )

  setUp(
    getHelloWorld.inject(
      constantUsersPerSec(500).during(10 minutes)
    ).protocols(httpConf)
  )
}