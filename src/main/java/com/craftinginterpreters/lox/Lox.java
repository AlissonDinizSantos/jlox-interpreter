package com.craftinginterpreters.lox;

import java.io.IOException;

public class Lox {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64); 
        } else if (args.length == 1) {
            System.out.println("Executando arquivo: " + args[0]);
            // runFile(args[0]); // Implementaremos depois
        } else {
            System.out.println("Entrando no modo interativo (REPL)...");
            // runPrompt();      // Implementaremos depois
        }
    }
}