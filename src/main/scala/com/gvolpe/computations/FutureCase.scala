package com.gvolpe.computations

import com.gvolpe.computations.fileops.WordCounter

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureCase extends WordCount {

  override def wordCount: Int = {
    val f = for {
      r1 <- WordCounter("star")
      r2 <- WordCounter("wars")
      r3 <- WordCounter("vader")
    } yield (r1 + r2 + r3)

    Await.result(f, 200 millis)
  }

}
