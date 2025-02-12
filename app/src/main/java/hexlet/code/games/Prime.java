package hexlet.code.games;

import java.util.Random;

public final class Prime {

    public static final String INTRODUCING_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%d";
    private static final int MAX_VALUE = 100;

    public static String[][] generate(int rounds, Random generator) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int number = generator.nextInt(1, MAX_VALUE);

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
