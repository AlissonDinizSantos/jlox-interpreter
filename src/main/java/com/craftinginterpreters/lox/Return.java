package com.craftinginterpreters.lox;

class Return extends RuntimeException {

    final Object value;

    Return(Object value) {
        super(null, null, false, false); // Otimização: não gera stack trace (é rápido)
        this.value = value;
    }
}
