package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    static final int ROUNDS = 3;
    static final String YES = "yes";
    static final String NO = "no";

    public static void start(Scanner in, String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random generator = new Random();

        int counter = 0;

        while (counter < Even.ROUNDS){
            int number = Even.getNumber(generator);

            System.out.printf("Question: %d\n", number);
            System.out.print("Your answer: ");
            String answer = in.next();
            String correctAnswer = (number % 2 == 0)? Even.YES : Even.NO;

            if (!answer.equals(correctAnswer)){
                Even.printLosePhrase(answer, correctAnswer, name);
                return;
            }

            System.out.println("Correct!");
            counter += 1;
        }
        System.out.printf("Congratulations, %s!\n", name);
    }

    static int getNumber(Random generator){
        return generator.nextInt(1000);
    }

    static void printLosePhrase(String answer, String correctAnswer, String name){
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'\n", answer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", name);
    }
}
