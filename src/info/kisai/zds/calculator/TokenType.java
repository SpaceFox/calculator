package info.kisai.zds.calculator;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by spacefox on 08/10/15.
 */
public enum TokenType implements Processor {

    NUMBER((token, queue, stack) -> queue.add(token)),
    FUNCTION((token, queue, stack) -> stack.push(token)),
    FUNCTION_ARG_SEPARATOR((token, queue, stack) -> {
        // TODO
    }),
    OPERATOR(),
    LEFT_PARENTHESIS((token, queue, stack) -> stack.push(token)),
    RIGHT_PARENTHESIS,
    NEGATIVE_OR_OPERATOR((token, queue, stack) -> {}),
    ;

    public static final Map<Character, TokenType> TYPE_DISCRIMINANTS = new HashMap<>();
    static {
        TYPE_DISCRIMINANTS.put('0', NUMBER);
        TYPE_DISCRIMINANTS.put('1', NUMBER);
        TYPE_DISCRIMINANTS.put('2', NUMBER);
        TYPE_DISCRIMINANTS.put('3', NUMBER);
        TYPE_DISCRIMINANTS.put('4', NUMBER);
        TYPE_DISCRIMINANTS.put('5', NUMBER);
        TYPE_DISCRIMINANTS.put('6', NUMBER);
        TYPE_DISCRIMINANTS.put('7', NUMBER);
        TYPE_DISCRIMINANTS.put('8', NUMBER);
        TYPE_DISCRIMINANTS.put('9', NUMBER);
        TYPE_DISCRIMINANTS.put('.', NUMBER);
        TYPE_DISCRIMINANTS.put('-', NEGATIVE_OR_OPERATOR);
        TYPE_DISCRIMINANTS.put('+', OPERATOR);
        TYPE_DISCRIMINANTS.put('*', OPERATOR);
        TYPE_DISCRIMINANTS.put('/', OPERATOR);
        TYPE_DISCRIMINANTS.put('^', OPERATOR);
        TYPE_DISCRIMINANTS.put(',', FUNCTION_ARG_SEPARATOR);
        TYPE_DISCRIMINANTS.put('(', LEFT_PARENTHESIS);
        TYPE_DISCRIMINANTS.put(')', RIGHT_PARENTHESIS);
    }

    private Processor processor;

    TokenType(Processor processor) {
        this.processor = processor;
    }

    public void process(Token token, Queue<Token> queue, Deque<Token> stack) {

        new Processor() {
            @Override
            public void process(Token token, Queue<Token> queue, Deque<Token> stack) {

            }
        };

        processor.process(token, queue, stack);
    }
}
