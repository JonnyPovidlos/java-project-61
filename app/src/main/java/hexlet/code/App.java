package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;


public class App {
    public static final int MAX_ROUNDS = 3;

    public static final int EVEN_MAX_VALUE = 1000;

    public static final int CALC_MAX_OPERANDS_VALUE = 100;

    public static final int GCD_MAX_OPERANDS_VALUE = 100;

    public static final int PROGRESSION_MIN_LENGTH = 5;
    public static final int PROGRESSION_MAX_GENERATOR = 10;
    public static final int PROGRESSION_MAX_STEP = 10;
    public static final int PROGRESSION_MAX_FIRST_VALUE = 10;

    public static final int PRIME_MAX_VALUE = 100;


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

        String player;

        switch (input) {
            case EXIT:
                return;
            case GREET:
                greeting(in);
                return;
            case EVEN:
                player = greeting(in);
                Even.run(player, in, MAX_ROUNDS, EVEN_MAX_VALUE);
                break;
            case CALC:
                player = greeting(in);
                Calc.run(player, in, MAX_ROUNDS, CALC_MAX_OPERANDS_VALUE);
                break;
            case GCD:
                player = greeting(in);
                Gcd.run(player, in, MAX_ROUNDS, GCD_MAX_OPERANDS_VALUE);
                break;
            case PROGRESSION:
                player = greeting(in);
                Progression.run(player, in, MAX_ROUNDS, PROGRESSION_MIN_LENGTH, PROGRESSION_MAX_GENERATOR,
                        PROGRESSION_MAX_STEP, PROGRESSION_MAX_FIRST_VALUE);
                break;
            case PRIME:
                player = greeting(in);
                Prime.run(player, in, MAX_ROUNDS, PRIME_MAX_VALUE);
                break;
            default:
                System.out.println("Incorrect number of game.");
        }
    }

    public static String greeting(Scanner in) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = in.next();
        System.out.printf("Hello, %s!\n", name);
        return name;
    }
}
