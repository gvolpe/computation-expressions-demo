computation-expressions-demo
============================

Simple comparison of the use of the standard Scala Future and the [scala async library](https://github.com/scala/async) for asynchronous computation.

## Benchmarks

After running every application (both FutureApp and AsyncAwaitApp) 10 times, this are the results for the average time performing the sum of three simple Math.sqrt operations:

#### Future
* 17.3 ms (16 15 20 15 13 14 12 26 22 20)

#### AsyncWait
* 6 ms (6 9 5 5 6 8 5 6 5 5)
