package com.gvolpe.computations

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureSequenceApp extends App {

  val (n1, n2, n3) = (Future(Math.sqrt(7891.12)), Future(Math.sqrt(995522.54)), Future(Math.sqrt(359.87)))

  val start = System.currentTimeMillis()

  val f = Future.sequence(Seq(n1, n2, n3))
  f.onComplete {
    case Success(result) =>
      println(s"SUM ${result.sum}")
      println(s"TIME (ms): ${System.currentTimeMillis() - start}")
    case Failure(e) => println(s"ERROR: ${e.getMessage}")
  }

  Thread.sleep(200)

}
