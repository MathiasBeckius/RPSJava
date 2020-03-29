# Rock-Paper-Scissors

## Description

This is a terminal-based version of the classic [Rock-Paper-Scissors](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors) game, written in Java.

The only reason of creating this game was to practice on object-oriented principles such as Domain-Driven Design.

One of my main design goals was to use a limited count of if-statements and especially
avoiding if-else - an idea I got from [Fred George](https://github.com/fredgeorge).
I can highly recommend his talks on Youtube!

Another design goal was to be very strict on how to handle null at the boundaries of interfaces:

1. If null is passed to a method or constructor, always fail fast (of course!).
2. null is never used as return values (used way often in all kinds of libraries).

Besides being a potential time-bomb, null is not a good information carrier.

FOOBAR
