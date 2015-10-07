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

    public double eval(String in) {
        String rpnNotation = shuntingYard(in);
        return 0;
    }

    private String shuntingYard(String in) {

        List<Token> tokens = tokenize(in);

        System.out.println(tokens);

        final Queue<String> queue = new LinkedList<>();
        final Deque<String> stack = new LinkedList<>();

        return null;
    }

    private List<Token> tokenize(String in) {

        StringBuilder buffer = new StringBuilder();
        List<Token> out = new LinkedList<>();
        char[] chars = in.toCharArray();

        Type previousTokenType = null, type;
        boolean isSpaceChar;
        for (char c : chars) {

            type = null;
            isSpaceChar = Character.isSpaceChar(c);
            if (Token.TYPE_DISCRIMINANTS.containsKey(c)) {
                type = Token.TYPE_DISCRIMINANTS.get(c);
            } else if (!isSpaceChar) {
                type = Type.FUNCTION;
            }
            if (previousTokenType == Type.NEGATIVE_OR_OPERATOR) {
                final Token lastToken = out.get(out.size() - 1);
                // Supposition : on a pas 2 nombres à la suite. Permet d'interpréter les formes comme "1-1".
                if (type != Type.NUMBER || (lastToken != null && lastToken.getType() == Type.NUMBER)) {
                    out.add(new Token(Type.OPERATOR, "-"));
                    buffer = new StringBuilder();
                }
            }
            if (    previousTokenType != null
                &&  previousTokenType != Type.NEGATIVE_OR_OPERATOR
                && (isSpaceChar || type != previousTokenType)
            ) {
                out.add(new Token(previousTokenType, buffer.toString()));
                buffer = new StringBuilder();
            }
            previousTokenType = type;
            if (!isSpaceChar) {
                buffer.append(c);
            }
        }
        out.add(new Token(previousTokenType, buffer.toString()));
        return out;
    }
}
