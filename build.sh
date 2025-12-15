#!/bin/bash
rm -rf bin/*
javac -d bin src/main/java/com/craftinginterpreters/lox/*.java
if [ $? -eq 0 ]; then
    java -cp bin com.craftinginterpreters.lox.Lox "$@"
fi
