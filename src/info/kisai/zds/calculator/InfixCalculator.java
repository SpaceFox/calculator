package info.kisai.zds.calculator;

import info.kisai.zds.calculator.Token.Type;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by spacefox on 06/10/15.
 */
public class InfixCalculator {

    private RPNCalculator rpnCalculator = new RPNCalculator();

    public double eval(String in) throws ParenthesisMismatchException, UnknownElementException, NotEnoughOperandsException {
        String rpnNotation = shuntingYard(in);

        System.out.println(rpnNotation);

        return rpnCalculator.eval(rpnNotation);
    }

    private String shuntingYard(String in) throws ParenthesisMismatchException {

        List<Token> tokens = tokenize(in);

        System.out.println(tokens);

        final Queue<Token> queue = new LinkedList<>();
        final Deque<Token> stack = new LinkedList<>();

        for (Token token : tokens) {
            switch (token.getType()) {
                case NUMBER:
                    queue.add(token);
                    break;
                case FUNCTION:
                    stack.push(token);
                    break;
                case FUNCTION_ARG_SEPARATOR:
                    while (stack.getFirst().getType() != Type.OPEN_PARENTHESIS) {
                        queue.add(stack.pop());
                    }
                    break;
                case OPERATOR:
                    final Operator o1 = RPNCalculator.OPERATORS.get(token.getValue());
                    Operator o2 = stack.isEmpty() ? null : RPNCalculator.OPERATORS.get(stack.getFirst().getValue());
                    while ( o2 != null
                        &&  (   (o1.isLeftAssociative()   && o1.getPrecedence() <= o2.getPrecedence())
                            ||  (!o1.isLeftAssociative()  && o1.getPrecedence() < o2.getPrecedence())
                        )
                    ) {
                        queue.add(stack.pop());
                        o2 = stack.isEmpty() ? null : RPNCalculator.OPERATORS.get(stack.getFirst().getValue());
                    }
                    stack.add(token);
                    break;
                case OPEN_PARENTHESIS:
                    stack.push(token);
                    break;
                case CLOSE_PARENTHESIS:
                    while (stack.getFirst().getType() != Type.OPEN_PARENTHESIS) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                    if (stack.getFirst().getType() == Type.FUNCTION) {
                        queue.add(stack.pop());
                    }
                    break;
            }
            System.out.println(queue + "\t\t" + stack);
        }
        while (!stack.isEmpty()) {
            if (stack.getFirst().getType() == Type.OPEN_PARENTHESIS) {
                throw new ParenthesisMismatchException(in);
            }
            queue.add(stack.pop());
        }

        StringBuilder buffer = new StringBuilder();
        for (Token token : queue) {
            buffer.append(token.getValue()).append(" ");
        }

        return buffer.toString();
    }

    private List<Token> tokenize(String in) {

        StringBuilder buffer = new StringBuilder();
        List<Token> out = new LinkedList<>();
        char[] chars = in.toCharArray();

        Type previousType = null, type;
        boolean isSpaceChar;
        for (char c : chars) {

            type = null;
            isSpaceChar = Character.isSpaceChar(c);
            if (Token.TYPE_DISCRIMINANTS.containsKey(c)) {
                type = Token.TYPE_DISCRIMINANTS.get(c);
            } else if (!isSpaceChar) {
                type = Type.FUNCTION;
            }
            if (previousType == Type.NEGATIVE_OR_OPERATOR) {
                final Token lastToken = out.get(out.size() - 1);
                // Supposition : on a pas 2 nombres à la suite. Permet d'interpréter les formes comme "1-1".
                if (type != Type.NUMBER || (lastToken != null && lastToken.getType() == Type.NUMBER)) {
                    out.add(new Token(Type.OPERATOR, "-"));
                    buffer = new StringBuilder();
                }
            }
            if (    previousType != null
                &&  previousType != Type.NEGATIVE_OR_OPERATOR
                && (isSpaceChar || type != previousType)
            ) {
                out.add(new Token(previousType, buffer.toString()));
                buffer = new StringBuilder();
            }
            previousType = type;
            if (!isSpaceChar) {
                buffer.append(c);
            }
        }
        out.add(new Token(previousType, buffer.toString()));
        return out;
    }
}
