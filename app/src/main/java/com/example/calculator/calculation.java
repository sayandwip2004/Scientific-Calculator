package com.example.calculator;

public class calculation {
    double evaluate(String str) {
        try {
            return new Object() {
                int pos = -1, ch;


                void nextChar() { ch = (++pos < str.length()) ? str.charAt(pos) : -1; }
                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) { nextChar(); return true; }
                    return false;
                }
                double parse() { nextChar(); return parseExpression(); }
                double parseExpression() {
                    double x = parseTerm();
                    while (true) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }
                double parseTerm() {
                    double x = parseFactor();
                    while (true) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else return x;
                    }
                }
                double parseFactor() {
                    if (eat('+')) return parseFactor();
                    if (eat('-')) return -parseFactor();
                    double x;
                    int startPos = pos;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if (ch >= '0' && ch <= '9' || ch == '.') {
                        while (ch >= '0' && ch <= '9' || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, pos));
                    } else if (ch >= 'a' && ch <= 'z') {
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = str.substring(startPos, pos);
                        x = parseFactor();
                        if (func.equals("sqrt")) x = Math.sqrt(x);
                        else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                        else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                        else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                        else if (func.equals("log")) x = Math.log10(x);
                        else if (func.equals("ln")) x = Math.log(x);
                        else throw new RuntimeException("Unknown function: " + func);
                    } else throw new RuntimeException("Unexpected: " + (char)ch);
                    if (eat('^')) x = Math.pow(x, parseFactor());
                    return x;
                }

            }.parse();
        }

        catch (Exception e) {
            return Double.NaN;
        }
}}
