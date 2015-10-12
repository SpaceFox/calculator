package info.kisai.zds.calculator;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by spacefox on 04/10/15.
 */
public class RPNCalculator {

    public static final Map<String, Operator> OPERATORS = new HashMap<>();
    static {
        OPERATORS.put("+", new Operator(2, true, (o1, o2) -> o1 + o2));
        OPERATORS.put("-", new Operator(2, true, (o1, o2) -> o1 - o2));
        OPERATORS.put("*", new Operator(3, true, (o1, o2) -> o1 * o2));
        OPERATORS.put("/", new Operator(3, true, (o1, o2) -> o1 / o2));
        OPERATORS.put("^", new Operator(4, false, (o1, o2) -> Math.pow(o1, o2)));
    }

    private Deque<Double> stack = new LinkedList<>();

    public double eval(String in) throws UnknownElementException, NotEnoughOperandsException {
        stack.clear();
        String[] elements = in.split("\\s");
        for (String e : elements) {
            if (!"".equalsIgnoreCase(e.trim())) {
                if (OPERATORS.containsKey(e)) {
                    Double o1 = null, o2 = null;
                    try {
                        o1 = stack.pop();
                        o2 = stack.pop();
                        stack.push(OPERATORS.get(e).getOperation().apply(o2, o1));
                    } catch (NoSuchElementException ex) {
                        throw new NotEnoughOperandsException(e, o1, o2, stack);
                    }
                } else {
                    try {
                        stack.push(Double.parseDouble(e));
                    } catch (NumberFormatException ex) {
                        throw new UnknownElementException(e, stack);
                    }
                }
            }
        }
        return stack.pop();
    }
}
