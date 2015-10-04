package info.kisai.zds.calculator;

import java.util.Scanner;

public class CLI {

    private RPNCalculator calculator = new RPNCalculator();

    private void show() {
        Scanner scanner = new Scanner(System.in);
        String in;
        System.out.println("Calculatrice en notation polonaise inversée");
        System.out.println("Tapez « q » pour quitter");
        while (true) {
            in = scanner.nextLine();
            if ("q".equalsIgnoreCase(in)) {
                System.out.println("Au revoir !");
                return;
            }
            try {
                System.out.println(calculator.eval(in));
            } catch (UnknownElementException | NotEnoughOperandsException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String... args) {
        new CLI().show();
    }
}
