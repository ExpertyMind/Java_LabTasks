package com.craftinginterpreters.ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.craftinginterpreters.ru.TokenType.*;

public class Scanner {
    List<Token> tokens = new ArrayList<>();
    private String source;
    private int line = 1;
    private int current;
    private int start;
    static HashMap<String, TokenType> keywords = new HashMap<>();

    static {
        keywords = new HashMap<>();
        keywords.put("aur",      AUR);
        keywords.put("jamaat",   JAMAAT);
        keywords.put("warna",    WARNA);
        keywords.put("jhoot",    JHOOT);
        keywords.put("kaam",     KAAM);
        keywords.put("ghumphir", GHUMPHIR);
        keywords.put("agar",     AGAR);
        keywords.put("khaali",   KHAALI);
        keywords.put("ya",       YA);
        keywords.put("likho",    LIKHO);
        keywords.put("likholn",  LIKHOLN);
        keywords.put("wapas",    WAPAS);
        keywords.put("upar",     UPAR);
        keywords.put("yeh",      YEH);
        keywords.put("sach",     SACH);
        keywords.put("rakho",    RAKHO);
        keywords.put("jabtak",   JABTAK);
    }



    Scanner(String source){
        this.source = source;
        current = 0;
        start = 0;
    }


    List<Token> getTokens(){
        while(!checkEnd()){
            start = current;
            scanToken();
        }


        tokens.add(new Token(KHATAM, "", null, line));
        return tokens;
    }

    void scanToken(){
        char ch = advance();

        switch (ch){
            // ignore
            case ' ':
            case '\r':
            case '\t':
                break;

            case '(': addToken(BAYA_QOS);   break;
            case ')': addToken(DAYA_QOS);   break;
            case '{': addToken(BAYA_QURLY); break;
            case '}': addToken(DAYA_QURLY); break;
            case ',': addToken(ALAG);       break;
            case '.': addToken(NUQTA);      break;
            case '-': addToken(TAFREEK);    break;
            case '+': addToken(JAMA);       break;
            case ';': addToken(WAQFA);      break;
            case '*': addToken(ZARB);       break;
            case '\n': line++;              break;
            case '!': addToken(match('=') ? NAHI_BARABAR : NAHI); break;
            case '=': addToken(match('=') ? BARABAR_HAI : BARABAR); break;
            case '>': addToken(match('=') ? BARA_BARABAR : BARA); break;
            case '<': addToken(match('=') ? CHHOTA_BARABAR : CHHOTA); break;
            case '/':
                if(match('/')){
                    while(!checkEnd() && peek() != '\n') {
                        advance();
                    }
                }
                else {
                    addToken(TAQSEEM);
                }
                break;
            case '"':
                while(!checkEnd() && peek() != '"'){
                    if(peek() == '\n') line++;
                    advance();
                }

                if (!checkEnd()) advance();
                else {
                    RU.Error(line, "GALTI JUMLE MAI.");
                    break;
                }

                String s = source.substring(start + 1, current - 1)
                        .replace("\\n", "\n")
                        .replace("\\t", "\t");
                addToken(JUMLA, s);
                break;

            default:
                if(isNum(ch)){
                    number();
                } else if (ch == '_' || isLetter(ch)) {
                    identifier();
                } else {
                    RU.Error(line, "Ghair mutawaqqa harf");
                }

        }
    }



    // Helper Methods
    private boolean checkEnd(){
        return current >= source.length();
    }

    private char advance(){
        if(checkEnd()) return '\0';

        char ch = source.charAt(current);
        current++;
        return ch;
    }

    private boolean match(char ch){
        if(checkEnd()) return false;

        if (peek() == ch){
            advance();
            return true;
        }

        return false;

    }

    private char peek(){
        if(checkEnd()) return '\0';

        return source.charAt(current);
    }

    private char peeknext(){
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isNum(char ch){
        return ch >= '0' && ch <= '9';
    }

    private boolean isLetter(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isAlphaNum(char ch){
        return isNum(ch) || isLetter(ch);
    }

    private void number(){
        while(isNum(peek())){
            advance();
        }

        if(peek() == '.' && isNum(peeknext())){
            advance();
            while (isNum(peek())){
                advance();
            }
        }

        Double value = Double.parseDouble(source.substring(start, current));

        addToken(ADAD, value);
    }

    private void identifier(){
        while (isAlphaNum(peek()) || peek() == '_'){
            advance();
        }

        String keyword = source.substring(start, current);
        TokenType type = keywords.get(keyword);

        if(type != null){
            addToken(type, keyword);
            return;
        }

        addToken(NAAM, keyword);
    }





    void addToken(TokenType type){
        addToken(type, null);
    }

    void addToken(TokenType type, Object value){
        String lexeme = source.substring(start, current);
        tokens.add(new Token(type, lexeme, value, line));
    }
}

class Scanning{
    static void main(String[] args) {
        Scanner sc = new Scanner("likholn a;");
        List<Token> tokens = sc.getTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }

    }
}
