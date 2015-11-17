package com.gvolpe.computations

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureSequenceCase extends ResultCase {

  override def sumResult: Double = {
    val f = Future.sequence(Seq(n1, n2, n3))
    Await.result(f, 200 millis).sum
  }

}
