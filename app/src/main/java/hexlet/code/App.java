package hexlet.code;

import java.util.Scanner;

public class App {
    static final int GREET = 1;
    static final int EVEN = 2;
    static final int EXIT = 0;
    static final String CHOICE_PHRASE = """
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
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
                App.greeting(in);
                break;
            case EVEN:
                String name = App.greeting(in);
                Even.start(in, name);
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
