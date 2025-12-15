package com.craftinginterpreters.lox;

import java.util.HashMap;
import java.util.Map;

class Environment {

    private final Map<String, Object> values = new HashMap<>();

    // Define uma variável (ex: var a = 1;)
    void define(String name, Object value) {
        values.put(name, value);
    }

    // Busca uma variável (ex: print a;)
    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        // Se a variável não existe, é um erro de tempo de execução!
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }
}
