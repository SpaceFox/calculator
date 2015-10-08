package info.kisai.zds.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spacefox on 06/10/15.
 */
public class Token {

    public static final Map<Character, TokenType> TYPE_DISCRIMINANTS = new HashMap<>();
    static {
        TYPE_DISCRIMINANTS.put('0', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('1', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('2', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('3', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('4', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('5', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('6', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('7', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('8', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('9', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('.', TokenType.NUMBER);
        TYPE_DISCRIMINANTS.put('-', TokenType.NEGATIVE_OR_OPERATOR);
        TYPE_DISCRIMINANTS.put('+', TokenType.OPERATOR);
        TYPE_DISCRIMINANTS.put('*', TokenType.OPERATOR);
        TYPE_DISCRIMINANTS.put('/', TokenType.OPERATOR);
        TYPE_DISCRIMINANTS.put('^', TokenType.OPERATOR);
        TYPE_DISCRIMINANTS.put(',', TokenType.FUNCTION_ARG_SEPARATOR);
        TYPE_DISCRIMINANTS.put('(', TokenType.LEFT_PARENTHESIS);
        TYPE_DISCRIMINANTS.put(')', TokenType.RIGHT_PARENTHESIS);
    }

    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
