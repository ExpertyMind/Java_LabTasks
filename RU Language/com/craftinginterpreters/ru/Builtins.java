package com.craftinginterpreters.ru;

import java.util.List;
import java.util.Random;

public class Builtins {
    static void define(Environment global) {

        global.define("darj", new RuCallable() {
            @Override public int arity() { return 1; }
            @Override public Object call(Interpreter interpreter, List<Object> arguments) {
                System.out.print(Interpreter.stringify(arguments.get(0)));
                return new java.util.Scanner(System.in).nextLine();
            }
        });

        global.define("qad", new RuCallable() {
            @Override public int arity() { return 1; }
            @Override public Object call(Interpreter interpreter, List<Object> arguments) {
                String s = (String) arguments.get(0);
                return (double) s.length();
            }
        });

        global.define("hissa", new RuCallable() {
            @Override public int arity() { return 3; }
            @Override public Object call(Interpreter interpreter, List<Object> arguments) {
                String s = (String) arguments.get(0);
                int start = ((Double) arguments.get(1)).intValue();
                int end = ((Double) arguments.get(2)).intValue();
                return s.substring(start, end);
            }
        });

        global.define("harf", new RuCallable() {
            @Override public int arity() { return 2; }
            @Override public Object call(Interpreter interpreter, List<Object> arguments) {
                String s = (String) arguments.get(0);
                int index = ((Double) arguments.get(1)).intValue();
                return String.valueOf(s.charAt(index));
            }
        });

        global.define("adad", new RuCallable() {
            @Override public int arity() { return 1; }
            @Override public Object call(Interpreter interpreter, List<Object> arguments) {
                String s = (String) arguments.get(0);
                return Double.parseDouble(s);
            }
        });

        global.define("betarteeb", new RuCallable() {
            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                double start = (Double) arguments.get(0);
                double end = (Double) arguments.get(1);
                double RandNum = (int) new Random().nextDouble(start, end + 1);
                return RandNum;
            }

            @Override
            public int arity() {
                return 2;
            }
        });
    }
}