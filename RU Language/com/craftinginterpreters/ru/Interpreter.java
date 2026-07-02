package com.craftinginterpreters.ru;

import java.util.ArrayList;
import java.util.List;

public class Interpreter implements Expr.Visitor<Object>, Stmt.Visitor<Void> {

    final Environment global = new Environment();
    private Environment environment = global;
    List<Stmt> stmts;

    Interpreter() {
        Builtins.define(global);
    }

    void interpret(List<Stmt> statements) {
        try {
            stmts = statements;
            for (Stmt statement : statements) {
                execute(statement);
            }
        } catch (RuntimeError error) {
            RU.runtimeError(error);
        }
    }


    //                          Expressions
    @Override
    public Object visitBinaryExpr(Expr.Binary expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);

        switch (expr.operator.type) {
            // Arithmetic
            case JAMA:
                if (left instanceof Double && right instanceof Double) {
                    return (double) left + (double) right;
                }
                if (left instanceof String && right instanceof String) {
                    return (String) left + (String) right;
                }

                return stringify(String.valueOf(left)).concat(stringify(String.valueOf(right)));

                // throw new RuntimeError(expr.operator, "Operands lazmi do numbers ya do strings hone chahiye.");
            case TAFREEK:
                checkNumberOperand(expr.operator, left, right);
                return (double) left - (double) right;
            case ZARB:
                checkNumberOperand(expr.operator, left, right);
                return (double) left * (double) right;
            case TAQSEEM:
                checkNumberOperand(expr.operator, left, right);
                return (double) left / (double) right;

            // Logical
            case BARA:
                checkNumberOperand(expr.operator, left, right);
                return (double) left > (double) right;
            case BARA_BARABAR:
                checkNumberOperand(expr.operator, left, right);
                return (double) left >= (double) right;
            case CHHOTA:
                checkNumberOperand(expr.operator, left, right);
                return (double) left < (double) right;
            case CHHOTA_BARABAR:
                checkNumberOperand(expr.operator, left, right);
                return (double) left <= (double) right;
            case BARABAR_HAI:
                return isEqual(left, right);
            case NAHI_BARABAR:
                return !isEqual(left, right);

        }


        return null;
    }


    @Override
    public Object visitUnaryExpr(Expr.Unary expr) {
        Object right = evaluate(expr.right);

        switch (expr.operator.type) {
            case TAFREEK:
                checkNumberOperand(expr.operator, right);
                return -(double) right;
            case NAHI:
                return !isTruthy(right);
        }

        return null;
    }

    @Override
    public Object visitGroupingExpr(Expr.Grouping expr) {
        return evaluate(expr.expr);
    }

    @Override
    public Object visitLiteralExpr(Expr.Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitVariableExpr(Expr.Variable expr) {
        return environment.getValue(expr.identifier);
    }

    @Override
    public Object visitAssignExpr(Expr.Assign expr) {
        Object value = evaluate(expr.value);
        environment.assign(expr.identifier, value);
        return value;
    }

    @Override
    public Object visitLogicalExpr(Expr.Logical logical) {
        Object left = evaluate(logical.left);

        if (logical.operator.type == TokenType.YA) {
            if (isTruthy(left)) return left;
        } else {                            // AUR
            if (!isTruthy(left)) return left;
        }

        return evaluate(logical.right);
    }

    @Override
    public Object visitCallExpr(Expr.Call expr){
        List<Object> arguments = new ArrayList<>();
        Object callee = evaluate(expr.callee);

        for (Expr arg : expr.arguments){
            arguments.add(evaluate(arg));
        }

        if (!(callee instanceof RuCallable)) {
            throw new RuntimeError(expr.DayaQos, "Sirf functions call ho sakte hain.");
        }

        RuCallable function = (RuCallable) callee;
        if (arguments.size() != function.arity()) {
            throw new RuntimeError(expr.DayaQos, function.arity() + " arguments chahiye the, " + arguments.size() + " mile.");
        }

        return function.call(this, arguments);
    }


    //                      Statement
    @Override
    public Void visitPrintStmt(Stmt.Likho stmt) {
        Object value = evaluate(stmt.expression);
        if(stmt.newLine) System.out.println(stringify(value));
        else System.out.print(stringify(value));
        return null;
    }

    @Override
    public Void visitExpressionStmt(Stmt.Expression stmt) {
        evaluate(stmt.expression);
        return null;
    }

    @Override
    public Void visitAgarStmt(Stmt.Agar stmt) {
        Object condition = evaluate(stmt.condition);

        if(isTruthy(condition)){
            execute(stmt.agarBranch);
        }else if(stmt.warnaBranch != null){
            execute(stmt.warnaBranch);
        }

        return null;
    }

    @Override
    public Void visitJabtakStmt(Stmt.Jabtak stmt) {
        while (isTruthy(evaluate(stmt.condition))) {
            execute(stmt.body);
        }

        return null;
    }

    @Override
    public Void visitGhumphirStmt(Stmt.Ghumphir stmt) {
        if (stmt.initializer != null) execute(stmt.initializer);

        while (stmt.condition == null || isTruthy(evaluate(stmt.condition))) {
            execute(stmt.body);
            if (stmt.increment != null) evaluate(stmt.increment);
        }

        return null;
    }

    @Override
    public Void visitBlockStmt(Stmt.Block stmt) {
        Environment local = new Environment(this.environment);      // Creates a Local Env

        executeBlock(stmt.statements, local);
        return null;
    }

    void executeBlock(List<Stmt> statements, Environment env) {
        Environment previous = this.environment;                // Saves the Previous Env

        try {
            this.environment = env;                             // Switches the Env
            for (Stmt statement : statements) {
                execute(statement);
            }
        } finally {
            this.environment = previous;
        }
    }

    @Override
    public Void visitNaamStmt(Stmt.Naam stmt) {
        Object value = null;

        if(stmt.initializer != null){
            value = evaluate(stmt.initializer);
        }

        environment.define(stmt.naam.lexeme, value);

        return null;
    }

    @Override
    public Void visitKaamStmt(Stmt.Kaam stmt) {
        RuKaam function = new RuKaam(stmt, environment);
        environment.define(stmt.name.lexeme, function);
        return null;
    }

    @Override
    public Void visitWapasStmt(Stmt.Wapas stmt) {
        Object value = null;
        if(stmt.value != null){
            value = evaluate(stmt.value);
        }
        throw new Wapas(value);
    }

    //                      Helping Methods
    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    private void execute(Stmt stmt){
        stmt.accept(this);
    }

    private void checkNumberOperand(Token operator, Object... values) {
        for (Object value : values) {
            if (!(value instanceof Double)) throw new RuntimeError(operator, "Operand lazmi number hona chahiye.");
        }
    }

    private boolean isEqual(Object left, Object right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else return left.equals(right);
    }

    private boolean isTruthy(Object expr) {
        if (expr == null) return false;
        else if (expr instanceof Boolean) return (boolean) expr;
        else return true;
    }

    static String stringify(Object value) {
        if (value == null) return "khaali";
        if (value instanceof Boolean) return (boolean) value ? "sach" : "jhoot";
        if (value instanceof Double) {
            String text = value.toString();
            if (text.endsWith(".0")) text = text.substring(0, text.length() - 2);
            return text;
        }
        if(value instanceof String){
            String text = value.toString();
            if (text.endsWith(".0")) text = text.substring(0, text.length() - 2);
            return text;
        }

        return value.toString();
    }

}
class Interpreting{
    static void main(String[] args) {
        Scanner sc = new Scanner("2 * 3 == 12 / 2 ");
        List<Token> tokens = sc.getTokens();

        System.out.println(tokens);

        Parser parser = new Parser(tokens);
        //Expr expr = parser.parse();

        //new Interpreter().interpret();

    }
}
