package com.gvolpe.computations.fileops

import scala.concurrent.Future
// TODO: Need to configure an specific execution context for io operations
import scala.concurrent.ExecutionContext.Implicits.global

object WordCounter {

  def apply(filterWord: String) = wordCounter(filterWord)

  def wordCounter(filterWord: String): Future[Int] = Future {
    val file = io.Source.fromURL(getClass.getResource("/star-wars.txt"))

    file.getLines()
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
      .filterKeys(_.equalsIgnoreCase(filterWord))
      .values.sum
  }

}
