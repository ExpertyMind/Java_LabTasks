package com.craftinginterpreters.ru;

public class Wapas extends RuntimeException {
    final Object value;

    Wapas(Object value) {
        super(null, null, false, false);
        this.value = value;
    }

}
