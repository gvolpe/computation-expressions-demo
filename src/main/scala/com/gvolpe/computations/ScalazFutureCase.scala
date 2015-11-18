package com.gvolpe.computations

import scala.concurrent.duration._
import scalaz.Scalaz._
import scalaz.concurrent.Future

object ScalazFutureCase extends SumResult {

  val futures = Vector(Future(Math.sqrt(7891.12)), Future(Math.sqrt(995522.54)), Future(Math.sqrt(359.87)))

  override def sumResult: Double = {
    val sum = for {
      v <- futures.sequence[Future, Double]
    } yield v.sum

    sum.runFor(200 millis)
  }
}
