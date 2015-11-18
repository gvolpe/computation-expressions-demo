package com.gvolpe.computations

import com.gvolpe.computations.fileops.WordCounter

import scala.async.Async.{async, await}
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object AsyncAwaitCase extends WordCount {

  override def wordCount: Int = {
    val f = async {
      await(WordCounter("star")) + await(WordCounter("wars")) + await(WordCounter("vader"))
    }
    Await.result(f, 200 millis)
  }

}
