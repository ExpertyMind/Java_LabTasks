package com.craftinginterpreters.ru;

import java.util.List;

abstract class Stmt {
    interface Visitor<R>{
        R visitPrintStmt(Likho stmt);
        R visitExpressionStmt(Expression stmt);
        R visitAgarStmt(Agar stmt);
        R visitJabtakStmt(Jabtak stmt);
        R visitGhumphirStmt(Ghumphir stmt);
        R visitBlockStmt(Block stmt);
        R visitNaamStmt(Naam stmt);
        R visitKaamStmt(Kaam stmt);
        R visitWapasStmt(Wapas stmt);
    }

    abstract <R> R accept(Visitor<R> visitor);

    static class Likho extends Stmt {
        Likho(Expr expression, boolean newLine) {
            this.expression = expression;
            this.newLine = newLine;
        }

        final Expr expression;
        final boolean newLine;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitPrintStmt(this);
        }
    }

    static class Expression extends Stmt{
        Expression(Expr expression){
            this.expression = expression;
        }

        final Expr expression;


        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitExpressionStmt(this);
        }
    }

    static class Naam extends Stmt{
        Naam(Token naam, Expr initializer){
            this.naam = naam;
            this.initializer = initializer;
        }

        final Token naam;
        final Expr initializer;


        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitNaamStmt(this);
        }
    }

    static class Agar extends Stmt{
        Agar(Expr condition, Stmt agarBranch, Stmt warnaBranch){
            this.condition = condition;
            this.agarBranch = agarBranch;
            this.warnaBranch = warnaBranch;
        }

        final Expr condition;
        final Stmt agarBranch;
        final Stmt warnaBranch;


        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitAgarStmt(this);
        }
    }

    static class Jabtak extends Stmt{
        Jabtak(Expr condition, Stmt body){
            this.condition = condition;
            this.body = body;
        }

        final Expr condition;
        final Stmt body;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitJabtakStmt(this);
        }
    }

    static class Ghumphir extends Stmt{
        Ghumphir(Stmt initializer, Expr condition, Expr increment, Stmt body){
            this.initializer = initializer;
            this.condition = condition;
            this.increment = increment;
            this.body = body;
        }

        final Stmt initializer;
        final Expr condition;
        final Expr increment;
        final Stmt body;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitGhumphirStmt(this);
        }
    }

    static class Block extends Stmt{
        Block(List<Stmt> statements){
            this.statements = statements;
        }

        final List<Stmt> statements;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStmt(this);
        }

    }

    static class Kaam extends Stmt{
        Kaam(Token name, List<Token> params, List<Stmt> body) {
            this.name = name;
            this.params = params;
            this.body = body;
        }

        final Token name;
        final List<Token> params;
        final List<Stmt> body;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitKaamStmt(this);
        }
    }

    static class Wapas extends Stmt {
        Wapas(Token wapas, Expr value) {
            this.wapas = wapas;
            this.value = value;  // nullable
        }

        final Token wapas;
        final Expr value;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitWapasStmt(this);
        }
    }



}
