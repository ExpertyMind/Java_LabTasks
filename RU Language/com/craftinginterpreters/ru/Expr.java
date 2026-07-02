package com.craftinginterpreters.ru;

import java.util.List;

abstract class Expr {

    interface Visitor<R>{
        R visitBinaryExpr(Binary expr);
        R visitUnaryExpr(Unary expr);
        R visitGroupingExpr(Grouping expr);
        R visitLiteralExpr(Literal expr);
        R visitVariableExpr(Variable expr);
        R visitAssignExpr(Assign expr);
        R visitLogicalExpr(Logical expr);
        R visitCallExpr(Call expr);
    }

    abstract <R> R accept(Visitor<R> visitor);

    static class Binary extends Expr{
        Binary(Expr left, Token operator, Expr right){

            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final Expr left;
        final Token operator;
        final Expr right;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitBinaryExpr(this);
        }

    }

    static class Unary extends Expr{
        Unary(Token operator, Expr right){

            this.operator = operator;
            this.right = right;
        }

        final Token operator;
        final Expr right;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitUnaryExpr(this);
        }

    }

    static class Grouping extends Expr{
        Grouping(Expr expr){

            this.expr = expr;
        }

        final Expr expr;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitGroupingExpr(this);
        }

    }

    static class Literal extends Expr{
        Literal(Object value){
            this.value = value;
        }

        final Object value;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitLiteralExpr(this);
        }

    }

    static class Variable extends Expr{
        Variable(Token identifier){
            this.identifier = identifier;
        }

        final Token identifier;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitVariableExpr(this);
        }

    }

    static class Assign extends Expr{
        Assign(Token identifier, Expr expr){
            this.identifier = identifier;
            this.value = expr;
        }

        final Token identifier;
        final Expr value;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitAssignExpr(this);
        }

    }

    static class Logical extends Expr{
        Logical(Expr left, Token operator, Expr right){

            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final Expr left;
        final Token operator;
        final Expr right;

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitLogicalExpr(this);
        }

    }

    static class Call extends Expr{
        Call(Expr callee, List<Expr> arguments, Token DayaQos){
            this.callee = callee;
            this.DayaQos = DayaQos;
            this.arguments = arguments;
        }

        final Expr callee;
        final Token DayaQos;
        final List<Expr> arguments;

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitCallExpr(this);
        }

    }


}
