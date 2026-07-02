package com.craftinginterpreters.ru;

import java.util.ArrayList;
import java.util.List;
import static com.craftinginterpreters.ru.TokenType.*;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    /*
                            Expression
        expression()   → lowest precedence, calls assignment
        assignment()   → handles assignment of variables, calls equality
        or()
        and()
        equality()     → handles == and !=, calls comparison
        comparison()   → handles > < >= <=, calls term
        term()         → handles + -, calls factor
        factor()       → handles * /, calls unary
        unary()        → handles ! -, calls primary
        primary()      → highest precedence: numbers, strings, booleans, grouping

     */


    List<Stmt> parse() {
        List<Stmt> statements = new ArrayList<>();
        while (!checkEnd()) {
            statements.add(Declaration());
        }
        return statements;
    }

    //                          Declaration
    private Stmt Declaration() {
        if (match(RAKHO)) return naamDeclaration();

        if (match(KAAM)) return kaamDeclaration("Kaam");

        return statement();
    }


    //                          Declaration

    private Stmt naamDeclaration() {
        Token naam = consume(NAAM, "Rakho ke baad 'Naam' ki tawaqqo thi.");

        Expr initializer = null;
        if (match(BARABAR)) {
            initializer = expression();
        }
        consume(WAQFA, "Naam ke baad ';' ki tawaqqo thi.");

        return new Stmt.Naam(naam, initializer);
    }

    private Stmt kaamDeclaration(String kind) {
        List<Token> parameters = new ArrayList<>();
        List<Stmt> body;

        Token naam = consume(NAAM, kind + " Naam ki tawaqqo thi.");
        consume(BAYA_QOS, kind + " Naam ke baad '(' ki tawaqqo thi.");

        if (!check(DAYA_QOS)) {
            do {
                if (parameters.size() >= 255) {
                    error(peek(), "255 se zyada parameters nahi ho sakte.");
                }
                parameters.add(consume(NAAM, "Parameter name ki tawaqqo thi."));
            } while (match(ALAG));
        }
        consume(DAYA_QOS, "Naam ke baad ')' ki tawaqqo thi.");

        consume(BAYA_QURLY, kind + " body se pehle '{' ki tawaqqo thi.");

        body = block();


        return new Stmt.Kaam(naam, parameters, body);
    }


    //                          Statements
    private Stmt statement() {
        if (match(LIKHO)) return likhoStatement(false);

        if (match(LIKHOLN)) return likhoStatement(true);

        if (match(AGAR)) return agarStatement();

        if (match(JABTAK)) return jabtakStatement();

        if (match(GHUMPHIR)) return ghumphirStatement();

        if(match(WAPAS)) return wapasStatement();

        if (match(BAYA_QURLY)) return new Stmt.Block(block());


        return expressionStatement();
    }

    private Stmt likhoStatement(boolean newLine) {
        Expr expression = expression();
        consume(WAQFA, "Value ke baad ';' ki tawaqqo thi.");

        return new Stmt.Likho(expression, newLine);
    }

    private Stmt expressionStatement() {
        Expr expression = expression();
        consume(WAQFA, "Value ke baad ';' ki tawaqqo thi.");

        return new Stmt.Expression(expression);
    }

    private List<Stmt> block() {
        List<Stmt> statements = new ArrayList<>();
        while (!check(DAYA_QURLY) && !checkEnd()) {
            statements.add(Declaration());
        }

        consume(DAYA_QURLY, "'{' block ke baad '}' ki tawaqqo thi.");
        return statements;
    }

    private Stmt agarStatement() {
        consume(BAYA_QOS, "agar ke baad '(' ki tawaqqo thi.");
        Expr condition = expression();
        consume(DAYA_QOS, "agar ke baad ')' ki tawaqqo thi.");
        Stmt agarBranch = statement();

        Stmt warnaBranch = null;
        if (match(WARNA)) {
            warnaBranch = statement();
        }


        return new Stmt.Agar(condition, agarBranch, warnaBranch);

    }

    private Stmt jabtakStatement() {
        consume(BAYA_QOS, "jabtak ke baad '(' ki tawaqqo thi.");
        Expr condition = expression();
        consume(DAYA_QOS, "jabtak ke baad ')' ki tawaqqo thi.");

        Stmt body = statement();

        return new Stmt.Jabtak(condition, body);
    }

    private Stmt ghumphirStatement() {
        consume(BAYA_QOS, "ghumphir ke baad '(' ki tawaqqo thi.");

        Stmt initializer;
        if (match(WAQFA)) {
            initializer = null;
        } else if (match(RAKHO)) {
            initializer = naamDeclaration();
        } else {
            initializer = expressionStatement();
        }

        Expr condition = null;
        if (!check(WAQFA)) {
            condition = expression();
        }
        consume(WAQFA, "ghumphir mai ';' ki tawaqqo thi.");

        Expr increment = null;
        if (!check(DAYA_QOS)) {
            increment = expression();
        }
        consume(DAYA_QOS, "ghumphir ke baad ')' ki tawaqqo thi.");

        Stmt body = statement();

        return new Stmt.Ghumphir(initializer, condition, increment, body);
    }

    private Stmt wapasStatement(){
        Token wapas = previous();
        Expr value = null;

        if(!check(WAQFA)){
            value = expression();
        }

        consume(WAQFA, "wapas mai ';' ki tawaqqo thi.");

        return new Stmt.Wapas(wapas, value);
    }


    // ---------------------------------------------------------------------------------------------------
    private Expr expression() {
        Expr expr = assignment();
        return expr;
    }

    private Expr assignment() {
        Expr variable = ya();

        if (match(BARABAR)) {
            Token Barabar = previous();
            Expr right = assignment();

            if (variable instanceof Expr.Variable) {
                Token name = ((Expr.Variable) variable).identifier;
                return new Expr.Assign(name, right);
            }
            throw error(Barabar, "Assignment target ghalat hai.");
        }

        return variable;
    }

    private Expr ya() {
        Expr expr = aur();

        while (match(YA)) {
            Token operator = previous();
            Expr value = aur();

            expr = new Expr.Logical(expr, operator, value);
        }

        return expr;
    }

    private Expr aur() {
        Expr expr = equality();

        while (match(AUR)) {
            Token operator = previous();
            Expr value = equality();

            expr = new Expr.Logical(expr, operator, value);
        }

        return expr;
    }

    private Expr equality() {
        Expr expr = comparison();

        while (match(NAHI_BARABAR, BARABAR_HAI)) {
            Token operator = previous();
            Expr right = term();
            expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr comparison() {
        Expr expr = term();

        while (match(BARA, BARA_BARABAR, CHHOTA, CHHOTA_BARABAR)) {
            Token operator = previous();
            Expr right = term();
            expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr term() {
        Expr expr = factor();

        while (match(JAMA, TAFREEK)) {
            Token operator = previous();
            Expr right = factor();
            expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr factor() {
        Expr expr = unary();

        while (match(ZARB, TAQSEEM)) {
            Token operator = previous();
            Expr right = unary();
            expr = new Expr.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expr unary() {

        if (match(TAFREEK, NAHI)) {
            Token operator = previous();
            Expr right = unary();
            return new Expr.Unary(operator, right);
        }

        Expr expr = call();
        return expr;
    }

    private Expr call() {
        Expr expr = primary();

        while (true) {
            if (match(BAYA_QOS)) {
                expr = finishCall(expr);
            } else {
                break;
            }
        }
        return expr;
    }

    private Expr primary() {

        if (match(SACH)) return new Expr.Literal(true);

        if (match(JHOOT)) return new Expr.Literal(false);

        if (match(KHAALI)) return new Expr.Literal(null);

        if (match(ADAD, JUMLA)) return new Expr.Literal(previous().value);

        if (match(NAAM)) return new Expr.Variable(previous());

        if (match(BAYA_QOS)) {
            Expr expr = expression();
            consume(DAYA_QOS, "Expression ke baad ')' ki tawaqqo thi.");
            return new Expr.Grouping(expr);
        }


        throw error(peek(), "Expression ki tawaqqo thi.");    // ERROR
    }


    // ERRORS
    private Token consume(TokenType type, String message) {
        if (match(type)) {
            return previous();
        }
        throw error(peek(), message);
    }

    private ParseError error(Token token, String message) {
        RU.Error(token, message);
        return new ParseError();
    }

    private static class ParseError extends RuntimeException {
    }


    // Helper Methods
    private boolean checkEnd() {
        return peek().type == KHATAM;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Token advance() {
        if (!checkEnd()) {
            current++;
        }
        return previous();
    }

    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (peek().type == type) {
                advance();
                return true;
            }
        }
        return false;
    }

    private boolean check(TokenType type) {
        return peek().type == type;
    }

    private Expr finishCall(Expr callee) {
        List<Expr> arguments = new ArrayList<>();
        if (!check(DAYA_QOS)) {
            do {
                arguments.add(expression());
            } while (match(ALAG));
        }
        Token DayaQos = consume(DAYA_QOS, "Expression ke baad ')' ki tawaqqo thi.");
        return new Expr.Call(callee, arguments, DayaQos);
    }

}

class Parsing{
    static void main(String[] args) {
        Scanner sc = new Scanner("x = 10");
        List<Token> tokens = sc.getTokens();

        Parser parser = new Parser(tokens);
        System.out.println(parser.parse());

    }
}


