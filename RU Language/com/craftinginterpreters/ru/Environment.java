package com.craftinginterpreters.ru;

import java.util.HashMap;

public class Environment {
    final Environment enclosing;
    private final HashMap<String, Object> values = new HashMap<>();


    Environment() {
        this.enclosing = null;
    }  // global

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }  // local

    void define(String name, Object value) {
        values.put(name, value);
    }

    Object getValue(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        if (enclosing != null){
            return enclosing.getValue(name);
        }

        throw new RuntimeError(name, "'" + name.lexeme + "' pehchana nahi gaya.");
    }

    void assign(Token name, Object updatedValue) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, updatedValue);
            return;
        }
        if (enclosing != null) {
            enclosing.assign(name, updatedValue);
            return;
        }
        throw new RuntimeError(name, "'" + name.lexeme + "' pehchana nahi gaya.");
    }

}
