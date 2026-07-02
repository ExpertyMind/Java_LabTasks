package com.craftinginterpreters.ru;

import java.util.List;

public class RuKaam implements RuCallable{
    private final Stmt.Kaam declaration;  // the function's AST node (name, params, body)
    private final Environment closure;    // the environment where function was DEFINED

    public RuKaam(Stmt.Kaam declaration, Environment closure) {
        this.declaration = declaration;
        this.closure = closure;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment KaamEnv = new Environment(closure);
        for (int i = 0; i < arguments.size(); i++){
            KaamEnv.define(declaration.params.get(i).lexeme, arguments.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, KaamEnv);
        } catch (Wapas wapas){
            return wapas.value;
        }

        return null;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }
}
