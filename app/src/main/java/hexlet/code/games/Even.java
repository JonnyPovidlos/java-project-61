package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {

    public static final String INTRODUCING_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String QUESTION_PHRASE = "%s";
    private static final int MAX_VALUE = 1000;
    private static final int MAX_ROUNDS = 3;


    public static void run() {
        var questionsAnsAnswers = generate(MAX_ROUNDS, MAX_VALUE);

        Engine.run(questionsAnsAnswers, INTRODUCING_PHRASE);
    }


    private static String[][] generate(int rounds, int maxValue) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            var number = Utils.getRandomInt(0, maxValue);
            result[i][0] = String.format(QUESTION_PHRASE, number);
            result[i][1] = isEven(number) ? "yes" : "no";
        }
        return result;
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }
}
