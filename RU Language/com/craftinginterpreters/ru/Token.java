package com.craftinginterpreters.ru;

public class Token {
    TokenType type;
    String lexeme;
    Object value;
    int line;

    public Token(TokenType type, String lexeme, Object value, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.value = value;
        this.line = line;
    }

    @Override
    public String toString() {
        return type + " " + lexeme + " " + value;
    }
}
