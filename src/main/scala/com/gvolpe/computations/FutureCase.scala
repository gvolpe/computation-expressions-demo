package com.gvolpe.computations

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureCase extends ResultCase {

  override def sumResult: Double = {
    val f = for {
      r1 <- n1
      r2 <- n2
      r3 <- n3
    } yield (r1 + r2 + r3)

    Await.result(f, 200 millis)
  }

}
