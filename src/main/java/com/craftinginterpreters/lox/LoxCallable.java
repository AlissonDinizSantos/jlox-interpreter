package com.craftinginterpreters.lox;

import java.util.List;

interface LoxCallable {
    // Quantos argumentos a função espera?

    int arity();

    // O método que executa a função de verdade
    Object call(Interpreter interpreter, List<Object> arguments);
}
