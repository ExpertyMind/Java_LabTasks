package com.craftinginterpreters.ru;

import java.util.List;

interface RuCallable {
    Object call(Interpreter interpreter, List<Object> arguments);
    int arity();
}
