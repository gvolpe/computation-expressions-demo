computation-expressions-demo
============================

Simple comparison of the use of the standard Scala Future and the [scala async library](https://github.com/scala/async) for asynchronous computation.

## Benchmarks

Below you can see the results of two different configurations of [sbt-jmh](https://github.com/ktoso/sbt-jmh) in the Average Time mode to get the sum of three simple Math.sqrt operations:

### Running 3 iterations, 10 warmup iterations, 3 forks and 1 thread

```
> jmh:run -i 3 -wi 10 -f 3 -t 1 .*FutureBenchmark.*

[info] Running org.openjdk.jmh.Main
[info] # JMH 1.11 (released 67 days ago)
[info] # VM version: JDK 1.8.0_66, VM 25.66-b17
[info] # VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 10 iterations, 1 s each
[info] # Measurement: 3 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Average time, time/op
```

##### Future Sequence
* 11455.322 ns/op
```
[info]   11455.322 ±(99.9%) 394.988 ns/op [Average]
[info]   (min, avg, max) = (11046.573, 11455.322, 11800.820), stdev = 235.051
[info]   CI (99.9%): [11060.334, 11850.309] assumes normal distribution
```

##### Future for-comprehension
* 7116.502 ns/op
```
[info]   7116.502 ±(99.9%) 1457.952 ns/op [Average]
[info]   (min, avg, max) = (5980.355, 7116.502, 8138.186), stdev = 867.604
[info]   CI (99.9%): [5658.550, 8574.454] assumes normal distribution
```

##### AsyncAwait
* 2026.783 ns/op
```
[info]   2026.783 ±(99.9%) 1278.719 ns/op [Average]
[info]   (min, avg, max) = (1239.381, 2026.783, 3394.910), stdev = 760.945
[info]   CI (99.9%): [748.064, 3305.502] assumes normal distribution
```

### Summarizing
```
[info] Benchmark                             Mode  Cnt      Score      Error  Units
[info] FutureBenchmark.asyncAwaitResult      avgt    9   2026.783 ± 1278.719  ns/op
[info] FutureBenchmark.futureResult          avgt    9   7116.502 ± 1457.952  ns/op
[info] FutureBenchmark.futureSequenceResult  avgt    9  11455.322 ±  394.988  ns/op
```

### Running 20 iterations, 20 warmup iterations, 10 forks and 1 thread

```
> jmh:run -i 20 -wi 20 -f 10 -t 1 .*FutureBenchmark.*

[info] Running org.openjdk.jmh.Main 
[info] # JMH 1.11 (released 67 days ago)
[info] # VM version: JDK 1.8.0_66, VM 25.66-b17
[info] # VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 20 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Average time, time/op
```

##### Future Sequence
* 10805.773 ns/op
```
[info]   10805.773 ±(99.9%) 226.244 ns/op [Average]
[info]   (min, avg, max) = (7053.947, 10805.773, 12008.504), stdev = 957.932
[info]   CI (99.9%): [10579.528, 11032.017] assumes normal distribution
```

##### Future for-comprehension
* 6762.131 ns/op
```
[info]   6762.131 ±(99.9%) 210.806 ns/op [Average]
[info]   (min, avg, max) = (5068.813, 6762.131, 8439.167), stdev = 892.564
[info]   CI (99.9%): [6551.325, 6972.936] assumes normal distribution
```

##### AsyncAwait
* 1999.398 ns/op
```
[info]   1999.398 ±(99.9%) 132.615 ns/op [Average]
[info]   (min, avg, max) = (1143.638, 1999.398, 3617.170), stdev = 561.502
[info]   CI (99.9%): [1866.782, 2132.013] assumes normal distribution
```

### Summarizing
```
[info] Benchmark                             Mode  Cnt      Score     Error  Units
[info] FutureBenchmark.asyncAwaitResult      avgt  200   1999.398 ± 132.615  ns/op
[info] FutureBenchmark.futureResult          avgt  200   6762.131 ± 210.806  ns/op
[info] FutureBenchmark.futureSequenceResult  avgt  200  10805.773 ± 226.244  ns/op
```

***The machine used to run this benchmark is an Intel® Xeon(R) CPU X5687 @ 3.60GHz × 4 with 23.5 GiB of memory running on Ubuntu 14.04 LTS 64 bits and Java 8.***
