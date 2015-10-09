package info.kisai.zds.calculator;

import java.util.Deque;
import java.util.Queue;

/**
 * Created by spacefox on 06/10/15.
 */
public class Token {

    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public void process(Queue<Token> queue, Deque<Token> stack) {
        type.process(this, queue, stack);
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
