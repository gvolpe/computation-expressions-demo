computation-expressions-demo
============================

Simple comparison of the use of the standard Scala Future and the [scala async library](https://github.com/scala/async) for asynchronous computation.

## Benchmarks

After running every application 10 times, this are the results for the average time performing the sum of three simple Math.sqrt operations:

#### Future Sequence
* 17.3 ms (16 15 20 15 13 14 12 26 22 20)

#### Future for-comprehension
* 13.4 ms (17 9 8 11 14 17 8 19 12 19)

#### AsyncAwait
* 6 ms (6 9 5 5 6 8 5 6 5 5)

The machine used to run this benchmark is an Intel® Xeon(R) CPU X5687 @ 3.60GHz × 4 with 23.5 GiB of memory running on Ubuntu 14.04 LTS 64 bits.
