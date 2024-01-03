package br.com.lorival.reactivejavatemplate.load.tests

//import br.com.lorival.reactivejavatemplate.load.tests.PerfTestConfig._
//import io.gatling.core.Predef.{constantUsersPerSec, global, scenario, _}
//import io.gatling.core.structure.ScenarioBuilder
//import io.gatling.http.Predef.{http, status, _}
//import io.gatling.http.protocol.HttpProtocolBuilder
//
//import scala.concurrent.duration._
//import scala.language.postfixOps
//
//class PostPersonSimulation extends Simulation {
//
//  val httpConf: HttpProtocolBuilder = http.baseUrl(baseUrl)
//
//  val createPerson: ScenarioBuilder = scenario("Create Person")
//    .exec(http("Request - POST /persons")
//      .post("/persons")
//      .body(StringBody("""{"name": "Teste", "age": 30}""")).asJson
//      .check(status.is(201))
//    )
//
//  val constantLoad = constantUsersPerSec(100) during (5 minutes)
//  val peakLoad = constantUsersPerSec(500) during (1 minute)
//
//  setUp(
//    createPerson.inject(
//      constantLoad,
//      nothingFor(10 seconds), // pause for 10 seconds before the peak
//      peakLoad
//    ).protocols(httpConf)
//  )
//}