jnrffi-benchmark - an example of Scala and Rust integration

To build and run benchmark:

    brew install rust
    cargo build --release

Change the path in JnrBenchmark.scala to fit where you clone this repo

Then in SBT run

    jmh:run -w 5 -i 15 -f 3 org.velvia.JnrBenchmark
