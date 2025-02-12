package hexlet.code.games;

import java.util.Random;

public final class Even {
    public static final String INTRODUCING_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%s";
    private static final int MAX_VALUE = 10000;


    public static String[][] generate(int rounds, Random generator) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            var number = generator.nextInt(MAX_VALUE);
            result[i][0] = String.format(QUESTION_PHRASE, number);
            result[i][1] = isEven(number) ? "yes" : "no";
        }
        return result;
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }
}
