package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Even {
    public static final String INTRODUCING_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%s";

    public static void run(String player, Scanner in, int rounds, int maxValue) {
        var generator = new Random();
        var questionsAnsAnswers = generate(rounds, generator, maxValue);

        Engine.run(player, questionsAnsAnswers, INTRODUCING_PHRASE, in);
    }


    private static String[][] generate(int rounds, Random generator, int maxValue) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            var number = generator.nextInt(maxValue);
            result[i][0] = String.format(QUESTION_PHRASE, number);
            result[i][1] = isEven(number) ? "yes" : "no";
        }
        return result;
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }
}
