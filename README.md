Kotlox (WIP)
=======
![Build status](https://github.com/masoodfallahpoor/Kotlox/actions/workflows/build.yml/badge.svg?branch=master)

Kotlox is an interpreter for the [Lox programming language](https://craftinginterpreters.com/the-lox-language.html),
written in Kotlin/JVM.

It's not a mere "IntelliJ IDEA -> menu -> code -> Convert Java File to Kotlin File" conversion of the reference
Java [implementation](https://github.com/munificent/craftinginterpreters/tree/master/java/com/craftinginterpreters/lox)!
Each line of Kotlox is handcrafted. That's the reason why the implementation of Kotlox does not match the reference Java
implementation.

Build
-
The easiest way to build Kotlox is to use IntelliJ IDEA. Just import it into the IDE and build it! If you want to use
Kotlox outside the IDE, then you should create a JAR file.

Usage
-
With `Kotlox.jar` available, you can run it in two ways:

- Run Kotlox in REPL mode (`java -jar Kotlox.jar`),
- Run a script file (`java -jar Kotlox.jar [script_file]`)

Current Progress
-

Chapter 1: Introduction (done)

Chapter 2: A Map of the Territory (done)

Chapter 3: The Lox Language (done)

Chapter 4: Scanning (done)

Chapter 5: Representing Code (done)

Chapter 6: Parsing Expressions (done)

Chapter 7: Evaluating Expressions (done)

Chapter 8: Statements and State (done)

Chapter 9: Control Flow (done)

Chapter 10: Functions (I'm here!)

Unit Tests
-

There are a lot of unit tests in place to verify the correctness of the implementation. They can be found
[here](https://github.com/MasoodFallahpoor/Kotlox/tree/master/src/test/java/ir/fallahpoor/kotlox/interpreter).




