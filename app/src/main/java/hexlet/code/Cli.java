package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void AskName() {
        Scanner in = new Scanner(System.in);
        System.out.print("May I have your name? ");
        System.out.printf("Hello, %s!%n", in.next());
    }
}
