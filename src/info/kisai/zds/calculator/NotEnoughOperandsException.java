package info.kisai.zds.calculator;

import java.util.Deque;

/**
 * Created by spacefox on 04/10/15.
 */
public class NotEnoughOperandsException extends Exception {
    public NotEnoughOperandsException(String operator, Double o1, Double o2, Deque<Double> stack) {
        super("Pas assez d'opérandes pour traiter l'opérateur \"" + operator + "\". Trouvés : " + o1 + " ; " + o2 + "\n"
                + "État de la pile : " + stack);
    }
}
