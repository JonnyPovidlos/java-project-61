package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression {

    public static final String INTRODUCING_PHRASE = "What number is missing in the progression?";

    private static final String QUESTION_PHRASE = "%s";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_GENERATOR = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_FIRST_VALUE = 10;
    private static final int MAX_ROUNDS = 3;

    public static void run() {
        var questionsAndAnswers = generate(MAX_ROUNDS, MIN_LENGTH, MAX_GENERATOR, MAX_STEP, MAX_FIRST_VALUE);

        Engine.run(questionsAndAnswers, INTRODUCING_PHRASE);
    }

    private static String[][] generate(int rounds, int minLength, int maxGenerator, int maxStep,
                                       int maxFirstValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int length = Utils.getRandomInt(minLength, maxGenerator);
            int indexOfRemove = Utils.getRandomInt(0, length);

            String[] progression = getProgression(length, maxStep, maxFirstValue);

            String answer = progression[indexOfRemove];
            progression[indexOfRemove] = "..";

            result[i][0] = String.format(QUESTION_PHRASE, String.join(" ", progression));
            result[i][1] = answer;

        }

        return result;
    }

    private static String[] getProgression(int len, int maxStep, int maxFirstValue) {
        String[] progression = new String[len];
        int step = Utils.getRandomInt(1, maxStep);
        int progress = Utils.getRandomInt(0, maxFirstValue);

        progression[0] = Integer.toString(progress);

        for (int i = 1; i < progression.length; i++) {
            progress += step;
            progression[i] = Integer.toString(progress);
        }
        return progression;
    }
}
