package com.gvolpe.computations.benchmarks

import java.util.concurrent.TimeUnit

import com.gvolpe.computations.{FutureSequenceCase, FutureCase, AsyncAwaitCase}
import org.openjdk.jmh.annotations.{Benchmark, Mode, OutputTimeUnit, BenchmarkMode}

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class FutureBenchmark {

  @Benchmark
  def futureResult: Unit = FutureCase.wordCount

  @Benchmark
  def futureSequenceResult: Unit = FutureSequenceCase.wordCount

  @Benchmark
  def asyncAwaitResult: Unit = AsyncAwaitCase.wordCount

}
