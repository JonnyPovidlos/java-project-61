package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;


public class App {
    public static final int GREET = 1;
    public static final int EVEN = 2;
    public static final int CALC = 3;
    public static final int GCD = 4;
    public static final int PROGRESSION = 5;
    public static final int PRIME = 6;
    public static final int EXIT = 0;
    public static final String CHOICE_PHRASE = """
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            Your choice:\s""";

    public static void main(String[] args) {
        System.out.print(CHOICE_PHRASE);

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        switch (input) {
            case EXIT:
                return;
            case GREET:
                greeting(in);
                return;
            case EVEN:
                Even.run();
                break;
            case CALC:
                Calc.run();
                break;
            case GCD:
                Gcd.run();
                break;
            case PROGRESSION:
                Progression.run();
                break;
            case PRIME:
                Prime.run();
                break;
            default:
                System.out.println("Incorrect number of game.");
        }
    }

    public static void greeting(Scanner in) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = in.next();
        System.out.printf("Hello, %s!\n", name);
    }
}
