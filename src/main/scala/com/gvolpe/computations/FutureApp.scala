package com.gvolpe.computations

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object FutureApp extends App {

  val (n1, n2, n3) = (Future(Math.sqrt(7891.12)), Future(Math.sqrt(995522.54)), Future(Math.sqrt(359.87)))

  val start = System.currentTimeMillis()

  val f = for {
    r1 <- n1
    r2 <- n2
    r3 <- n3
  } yield (r1 + r2 + r3)

  f.onComplete {
    case Success(result) =>
      println(s"SUM ${result}")
      println(s"TIME (ms): ${System.currentTimeMillis() - start}")
    case Failure(e) => println(s"ERROR: ${e.getMessage}")
  }

  Await.ready(f, 200 millis)
}
