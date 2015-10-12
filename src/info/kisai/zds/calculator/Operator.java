package info.kisai.zds.calculator;

import java.util.function.BiFunction;

/**
 * Created by spacefox on 12/10/15.
 */
public class Operator {
    private int precedence;
    private boolean leftAssociative;
    private BiFunction<Double, Double, Double> operation;

    public Operator(int precedence, boolean leftAssociative, BiFunction<Double, Double, Double> operation) {
        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
        this.operation = operation;
    }

    public int getPrecedence() {
        return precedence;
    }

    public boolean isLeftAssociative() {
        return leftAssociative;
    }

    public BiFunction<Double, Double, Double> getOperation() {
        return operation;
    }
}
