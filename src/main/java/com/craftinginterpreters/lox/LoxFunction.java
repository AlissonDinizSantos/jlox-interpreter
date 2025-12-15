package com.craftinginterpreters.lox;

import java.util.List;

class LoxFunction implements LoxCallable {

    private final Stmt.Function declaration;
    private final Environment closure;
    private final boolean isInitializer;

    LoxFunction(Stmt.Function declaration, Environment closure, boolean isInitializer) {
        this.isInitializer = isInitializer;
        this.closure = closure;
        this.declaration = declaration;
    }

    // Método usado para atrelar o 'this' à instância quando acessamos um método
    LoxFunction bind(LoxInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new LoxFunction(declaration, environment, isInitializer);
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        // Cria um ambiente novo para a execução da função, tendo o closure como pai
        Environment environment = new Environment(closure);

        // Define os parâmetros no escopo local da função
        for (int i = 0; i < declaration.params.size(); i++) {
            environment.define(declaration.params.get(i).lexeme,
                    arguments.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            // Se for um inicializador (init), ele sempre retorna 'this',
            // mesmo que tenhamos chamado return vazio;
            if (isInitializer) {
                return closure.getAt(0, "this");
            }

            return returnValue.value;
        }

        // Se for inicializador e chegar ao fim sem return, retorna 'this' automaticamente
        if (isInitializer) {
            return closure.getAt(0, "this");
        }

        return null;
    }
}
