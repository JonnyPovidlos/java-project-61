package hexlet.code;

import java.util.Scanner;


public class App {
    public static final int GREET = 1;
    public static final int EVEN = 2;
    public static final int CALC = 3;
    public static final int EXIT = 0;
    public static final String CHOICE_PHRASE = """
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            0 - Exit
            Your choice:\s""";

    public static void main(String[] args) {
        System.out.print(CHOICE_PHRASE);

        Scanner in = new Scanner(System.in);

        int input = in.nextInt();
        IGame game;
        Engine engine;

        switch (input) {
            case EXIT:
                return;
            case GREET:
                greeting(in);
                break;
            case EVEN:
                game = new Even();
                engine = new Engine(game, greeting(in));
                engine.run(in);
                break;
            case CALC:
                game = new Calc();
                engine = new Engine(game, greeting(in));
                engine.run(in);
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
