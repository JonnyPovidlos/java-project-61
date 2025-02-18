package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Progression {

    public static final String INTRODUCING_PHRASE = "What number is missing in the progression?";

    private static final String QUESTION_PHRASE = "%s";

    public static void run(String player, Scanner in, int rounds, int minLength, int maxGenerator, int maxStep,
                           int maxFirstValue) {
        var generator = new Random();
        var questionsAndAnswers = generate(rounds, generator, minLength, maxGenerator, maxStep, maxFirstValue);

        Engine.run(player, questionsAndAnswers, INTRODUCING_PHRASE, in);
    }

    private static String[][] generate(int rounds, Random generator, int minLength, int maxGenerator, int maxStep,
                                       int maxFirstValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int length = generator.nextInt(maxGenerator) + minLength;
            int indexOfRemove = generator.nextInt(length);

            String[] progression = getProgression(length, generator, maxStep, maxFirstValue);

            String answer = progression[indexOfRemove];
            progression[indexOfRemove] = "..";

            result[i][0] = String.format(QUESTION_PHRASE, String.join(" ", progression));
            result[i][1] = answer;

        }

        return result;
    }

    private static String[] getProgression(int len, Random generator, int maxStep, int maxFirstValue) {
        String[] progression = new String[len];
        int step = generator.nextInt(1, maxStep);
        int progress = generator.nextInt(maxFirstValue);

        progression[0] = Integer.toString(progress);

        for (int i = 1; i < progression.length; i++) {
            progress += step;
            progression[i] = Integer.toString(progress);
        }
        return progression;
    }
}
