package com.gvolpe.computations

import scala.concurrent.duration._
import scalaz.Scalaz._
import scalaz.concurrent.Task

object ScalazTaskCase extends SumResult {

  val futures = Vector(Task(Math.sqrt(7891.12)), Task(Math.sqrt(995522.54)), Task(Math.sqrt(359.87)))

  override def sumResult: Double = {
    val sum = for {
      v <- futures.sequence[Task, Double]
    } yield v.sum

    sum.runFor(200 millis)
  }
}

