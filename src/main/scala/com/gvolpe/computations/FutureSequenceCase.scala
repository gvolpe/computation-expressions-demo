package com.gvolpe.computations

import com.gvolpe.computations.fileops.WordCounter

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureSequenceCase extends WordCount {

  override def wordCount: Int = {
    val f = Future.sequence(Seq(WordCounter("star"), WordCounter("wars"), WordCounter("vader")))
    Await.result(f, 200 millis).sum
  }

}
