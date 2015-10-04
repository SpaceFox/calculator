package info.kisai.zds.calculator;

import java.util.Deque;

/**
 * Created by spacefox on 04/10/15.
 */
public class UnknownElementException extends Exception {
    public UnknownElementException(String element, Deque<Double> stack) {
        super("Erreur de synaxe : l'élément \"" + element + "\" n'est ni un nombre, ni un opérateur connu.\n"
                + "État de la pile : " + stack);
    }
}
