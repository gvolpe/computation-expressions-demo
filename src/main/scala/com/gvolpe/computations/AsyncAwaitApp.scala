package com.gvolpe.computations

import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object AsyncAwaitApp extends App {

  val (n1, n2, n3) = (Future(Math.sqrt(7891.12)), Future(Math.sqrt(995522.54)), Future(Math.sqrt(359.87)))

  async {
    val start = System.currentTimeMillis()
    val result = await(n1) + await(n2) + await(n3)
    println(s"SUM ${result}")
    println(s"TIME (ms): ${System.currentTimeMillis() - start}")
  } onFailure { case e => println(s"ERROR: ${e.getMessage}") }

  Thread.sleep(200)

}
