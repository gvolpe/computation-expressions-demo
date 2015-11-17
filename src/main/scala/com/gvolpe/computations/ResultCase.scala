package com.gvolpe.computations

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait SumResult {
  def sumResult: Double
}

abstract class ResultCase extends SumResult {
  val (n1, n2, n3) = (Future(Math.sqrt(7891.12)), Future(Math.sqrt(995522.54)), Future(Math.sqrt(359.87)))
}
