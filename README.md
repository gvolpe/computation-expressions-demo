computation-expressions-demo
============================

Simple comparison of the use of the standard Scala Future and the [scala async library](https://github.com/scala/async) for asynchronous computation.

## Benchmarks

Below you can see the results of two different configurations of [sbt-jmh](https://github.com/ktoso/sbt-jmh) in the Average Time mode to get the sum of three simple Math.sqrt operations:

### Running 3 iterations, 10 warmup iterations, 3 forks and 1 thread

```
> jmh:run -i 3 -wi 10 -f 3 -t 1 .*FutureBenchmark.*

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

### Running 10 iterations, 20 warmup iterations, 3 forks and 3 threads

```
> jmh:run -i 10 -wi 20 -f 3 -t 3 .*FutureBenchmark.*

[info] # JMH 1.11 (released 68 days ago)
[info] # VM version: JDK 1.8.0_66, VM 25.66-b17
[info] # VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 10 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 3 threads, will synchronize iterations
[info] # Benchmark mode: Average time, time/op
```

##### Future Sequence
* 8031.084 ns/op
```
[info]   8031.084 ±(99.9%) 152.726 ns/op [Average]
[info]   (min, avg, max) = (7633.711, 8031.084, 8462.721), stdev = 228.594
[info]   CI (99.9%): [7878.358, 8183.811] (assumes normal distribution)
```

##### Future for-comprehension
* 5784.833 ns/op
```
[info]   5784.833 ±(99.9%) 111.269 ns/op [Average]
[info]   (min, avg, max) = (5511.050, 5784.833, 6183.225), stdev = 166.542
[info]   CI (99.9%): [5673.564, 5896.102] (assumes normal distribution)
```

##### AsyncAwait
* 2301.868 ns/op
```
[info]   2301.868 ±(99.9%) 59.583 ns/op [Average]
[info]   (min, avg, max) = (2161.460, 2301.868, 2570.022), stdev = 89.180
[info]   CI (99.9%): [2242.285, 2361.450] (assumes normal distribution)
```

### Summarizing
```
[info] Benchmark                             Mode  Cnt     Score     Error  Units
[info] FutureBenchmark.asyncAwaitResult      avgt   30  2301.868 ±  59.583  ns/op
[info] FutureBenchmark.futureResult          avgt   30  5784.833 ± 111.269  ns/op
[info] FutureBenchmark.futureSequenceResult  avgt   30  8031.084 ± 152.726  ns/op
```

### Running 10 iterations, 20 warmup iterations, 3 forks and 10 threads

```
> jmh:run -i 10 -wi 20 -f 3 -t 10 .*FutureBenchmark.*

[info] # JMH 1.11 (released 68 days ago)
[info] # VM version: JDK 1.8.0_66, VM 25.66-b17
[info] # VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 10 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 10 threads, will synchronize iterations
[info] # Benchmark mode: Average time, time/op
```

##### Future Sequence
* 14961.678 ns/op
```
[info]   14961.678 ±(99.9%) 728.887 ns/op [Average]
[info]   (min, avg, max) = (13986.257, 14961.678, 19160.387), stdev = 1090.963
[info]   CI (99.9%): [14232.791, 15690.564] (assumes normal distribution)
```

##### Future for-comprehension
* 12093.133 ns/op
```
[info]   12093.133 ±(99.9%) 429.764 ns/op [Average]
[info]   (min, avg, max) = (11153.901, 12093.133, 13656.094), stdev = 643.251
[info]   CI (99.9%): [11663.368, 12522.897] (assumes normal distribution)
```

##### AsyncAwait
* 11215.314 ns/op
```
[info]   11215.314 ±(99.9%) 402.305 ns/op [Average]
[info]   (min, avg, max) = (10154.243, 11215.314, 12701.153), stdev = 602.152
[info]   CI (99.9%): [10813.008, 11617.619] (assumes normal distribution)
```

### Summarizing
```
[info] Benchmark                             Mode  Cnt      Score     Error  Units
[info] FutureBenchmark.asyncAwaitResult      avgt   30  11215.314 ± 402.305  ns/op
[info] FutureBenchmark.futureResult          avgt   30  12093.133 ± 429.764  ns/op
[info] FutureBenchmark.futureSequenceResult  avgt   30  14961.678 ± 728.887  ns/op
```

### Running 10 iterations, 20 warmup iterations, 3 forks and 20 threads

```
> jmh:run -i 10 -wi 20 -f 3 -t 20 .*FutureBenchmark.*

[info] # JMH 1.11 (released 68 days ago)
[info] # VM version: JDK 1.8.0_66, VM 25.66-b17
[info] # VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 10 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 20 threads, will synchronize iterations
[info] # Benchmark mode: Average time, time/op
```

##### Future Sequence
* 32180.092 ns/op
```
[info]   32180.092 ±(99.9%) 737.500 ns/op [Average]
[info]   (min, avg, max) = (30431.238, 32180.092, 35036.343), stdev = 1103.856
[info]   CI (99.9%): [31442.592, 32917.592] (assumes normal distribution)
```

##### Future for-comprehension
* 26390.358 ns/op
```
[info]   26390.358 ±(99.9%) 905.957 ns/op [Average]
[info]   (min, avg, max) = (24657.209, 26390.358, 30023.414), stdev = 1355.994
[info]   CI (99.9%): [25484.401, 27296.315] (assumes normal distribution)
```

##### AsyncAwait
* 24401.617 ns/op
```
[info]   24401.617 ±(99.9%) 736.642 ns/op [Average]
[info]   (min, avg, max) = (22635.240, 24401.617, 26193.640), stdev = 1102.571
[info]   CI (99.9%): [23664.975, 25138.259] (assumes normal distribution)
```

### Summarizing
```
[info] Benchmark                             Mode  Cnt      Score     Error  Units
[info] FutureBenchmark.asyncAwaitResult      avgt   30  24401.617 ± 736.642  ns/op
[info] FutureBenchmark.futureResult          avgt   30  26390.358 ± 905.957  ns/op
[info] FutureBenchmark.futureSequenceResult  avgt   30  32180.092 ± 737.500  ns/op
```

***The machine used to run this benchmark is an Intel® Xeon(R) CPU X5687 @ 3.60GHz × 4 with 23.5 GiB of memory running on Ubuntu 14.04 LTS 64 bits and Java 8.***
