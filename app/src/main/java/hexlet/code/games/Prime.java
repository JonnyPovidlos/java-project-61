package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Prime {

    public static final String INTRODUCING_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%d";

    public static void run(String player, Scanner in, int rounds, int maxValue) {
        var generator = new Random();

        var questionsAndAnswers = generate(rounds, generator, maxValue);

        Engine.run(player, questionsAndAnswers, INTRODUCING_PHRASE, in);
    }

    private static String[][] generate(int rounds, Random generator, int maxValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int number = generator.nextInt(1, maxValue);

            result[i][0] = String.format(QUESTION_PHRASE, number);
            result[i][1] = isPrime(number) ? "yes" : "no";
        }

        return result;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
