package info.kisai.zds.calculator;

/**
 * Created by spacefox on 12/10/15.
 */
public class ParenthesisMismatchException extends Exception {
    public ParenthesisMismatchException(String expression) {
        super("Parenthèses incohérentes dans l'expression " + expression);
    }
}
