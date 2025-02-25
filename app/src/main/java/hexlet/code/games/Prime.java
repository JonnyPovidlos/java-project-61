package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {

    public static final String INTRODUCING_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%d";
    private static final int PRIME_MAX_VALUE = 100;
    private static final int MAX_ROUNDS = 3;

    public static void run() {

        var questionsAndAnswers = generate(MAX_ROUNDS, PRIME_MAX_VALUE);

        Engine.run(questionsAndAnswers, INTRODUCING_PHRASE);
    }

    private static String[][] generate(int rounds, int maxValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int number = Utils.getRandomInt(1, maxValue);

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
