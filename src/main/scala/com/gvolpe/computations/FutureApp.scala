package com.gvolpe.computations

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureApp extends App {

  val (n1, n2, n3) = (Future(3), Future(6), Future(1))

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
