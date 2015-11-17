package com.gvolpe.computations

import scala.async.Async.{async, await}
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object AsyncAwaitCase extends ResultCase {

  override def sumResult: Double = {
    val f = async {
      await(n1) + await(n2) + await(n3)
    }
    Await.result(f, 200 millis)
  }

}
