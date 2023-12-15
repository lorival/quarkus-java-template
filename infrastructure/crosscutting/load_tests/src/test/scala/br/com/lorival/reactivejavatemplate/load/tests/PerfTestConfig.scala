package br.com.lorival.reactivejavatemplate.load.tests

import SystemPropertiesUtil._

object PerfTestConfig {
  val baseUrl = getAsStringOrElse("baseUrl", "http://localhost:8080/api")
  val requestPerSecond = getAsDoubleOrElse("requestPerSecond", 100f)
  val durationMin = getAsDoubleOrElse("durationMin", 0.25)
  val meanResponseTimeMs = getAsIntOrElse("meanResponseTimeMs", 500)
  val maxResponseTimeMs = getAsIntOrElse("maxResponseTimeMs", 2000)
  val p95ResponseTimeMs = getAsIntOrElse("p95ResponseTimeMs", 250)
}