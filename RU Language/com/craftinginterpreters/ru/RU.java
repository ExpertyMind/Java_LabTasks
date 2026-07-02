package com.craftinginterpreters.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RU {
    static boolean hadError = false;
    static boolean hadRuntimeError = false;
    private static final Interpreter interpreter = new Interpreter();


    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Istemaal: ru [file_ka_naam]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runFile("C:\\Users\\Lenovo\\Documents\\Programming\\RU BACKUP\\Third Commit\\ru\\src\\com\\craftinginterpreters\\ru\\test2.ru");
            //runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
            hadError = false;

            System.out.println();
        }
    }

    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.getTokens();


        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse();

        if (hadError) return;
        interpreter.interpret(statements);
    }



    static void Error(int line, String message){
        report(line, "", message);
    }

    static void Error(Token token, String message){
        if (token.type == TokenType.KHATAM) {
            report(token.line, "akhir par", message);
        } else {
            report(token.line, " par '" + token.lexeme + "'", message);
        }
    }

    private static void report(int line, String where, String message){
        System.err.println("[Lakeer " + line + "] Galti: " + message);
        hadError = true;
    }

    public static void runtimeError(RuntimeError error){
        System.err.println(error.getMessage() + "\n[Lakeer " + error.token.line + "]");
        hadRuntimeError = true;
    }

}
