package org.velvia

import java.util.concurrent.TimeUnit

import jnr.ffi.LibraryLoader
import org.openjdk.jmh.annotations._

trait RustLib {
  def double_input(in: Int): Int
}

@State(Scope.Thread)
class JnrBenchmark {
  sys.props.put("jnr.ffi.library.path", s"${sys.env("HOME")}/src/rust/rust-filo/target/release")
  val rustLib = LibraryLoader.create(classOf[RustLib]).load("rust_filo")

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  def singleIntJnr(): Int = {
    rustLib.double_input(100)
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  @OperationsPerInvocation(100)
  def multiLoopIntJnr(): Unit = {
    var i = 0
    while (i < 100) {
      rustLib.double_input(100)
      i += 1
    }
  }
}