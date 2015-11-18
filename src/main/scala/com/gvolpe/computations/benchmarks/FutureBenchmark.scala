package com.gvolpe.computations.benchmarks

import java.util.concurrent.TimeUnit

import com.gvolpe.computations._
import org.openjdk.jmh.annotations.{Benchmark, Mode, OutputTimeUnit, BenchmarkMode}

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class FutureBenchmark {

  @Benchmark
  def futureResult: Unit = FutureCase.sumResult

  @Benchmark
  def futureSequenceResult: Unit = FutureSequenceCase.sumResult

  @Benchmark
  def asyncAwaitResult: Unit = AsyncAwaitCase.sumResult

  @Benchmark
  def scalazFutureResult: Unit = ScalazFutureCase.sumResult

  @Benchmark
  def scalazTaskResult: Unit = ScalazTaskCase.sumResult

}
