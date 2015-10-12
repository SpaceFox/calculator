package info.kisai.zds.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spacefox on 06/10/15.
 */
public class Token {

    public enum Type {
        NUMBER,
        FUNCTION,
        FUNCTION_ARG_SEPARATOR,
        OPERATOR,
        OPEN_PARENTHESIS,
        CLOSE_PARENTHESIS,
        NEGATIVE_OR_OPERATOR,
        ;
    }
    public static final Map<Character, Type> TYPE_DISCRIMINANTS = new HashMap<>();
    static {
        TYPE_DISCRIMINANTS.put('0', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('1', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('2', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('3', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('4', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('5', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('6', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('7', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('8', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('9', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('.', Type.NUMBER);
        TYPE_DISCRIMINANTS.put('-', Type.NEGATIVE_OR_OPERATOR);
        TYPE_DISCRIMINANTS.put('+', Type.OPERATOR);
        TYPE_DISCRIMINANTS.put('*', Type.OPERATOR);
        TYPE_DISCRIMINANTS.put('/', Type.OPERATOR);
        TYPE_DISCRIMINANTS.put('^', Type.OPERATOR);
        TYPE_DISCRIMINANTS.put(',', Type.FUNCTION_ARG_SEPARATOR);
        TYPE_DISCRIMINANTS.put('(', Type.OPEN_PARENTHESIS);
        TYPE_DISCRIMINANTS.put(')', Type.CLOSE_PARENTHESIS);
    }

    private Type type;
    private String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
//        return"Token{" +
//                "type=" + type +
//                ", value='" + value + '\'' +
//                '}';
        return value;
    }
}
