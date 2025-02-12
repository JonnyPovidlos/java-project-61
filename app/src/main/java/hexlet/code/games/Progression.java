package hexlet.code.games;

import java.util.Random;

public final class Progression {

    public static final String INTRODUCING_PHRASE = "What number is missing in the progression?";

    private static final String QUESTION_PHRASE = "%s";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_GENERATOR = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_FIRST_VALUE = 10;

    public static String[][] generate(int rounds, Random generator) {
        String[][] result = new String[3][2];

        for (int i = 0; i < rounds; i++) {
            int length = generator.nextInt(MAX_GENERATOR) + MIN_LENGTH;
            int indexOfRemove = generator.nextInt(length);

            String[] progression = getProgression(length, generator);

            String answer = progression[indexOfRemove];
            progression[indexOfRemove] = "..";

            result[i][0] = String.format(QUESTION_PHRASE, String.join(" ", progression));
            result[i][1] = answer;

        }

        return result;
    }

    private static String[] getProgression(int len, Random generator) {
        String[] progression = new String[len];
        int step = generator.nextInt(1, MAX_STEP);
        int progress = generator.nextInt(MAX_FIRST_VALUE);

        progression[0] = Integer.toString(progress);

        for (int i = 1; i < progression.length; i++) {
            progress += step;
            progression[i] = Integer.toString(progress);
        }
        return progression;
    }
//    public String getQuestion(Random generator) {
//        int length = generator.nextInt(MAX_GENERATOR) + MIN_LENGTH;
//        int indexOfRemove = generator.nextInt(length);
//        int step = generator.nextInt(1, MAX_STEP);
//        int firstValue = generator.nextInt(MAX_FIRST_VALUE);
//
//        StringBuilder result = new StringBuilder();
//        if (indexOfRemove == 0) {
//            result.append("..");
//            answer = firstValue;
//        } else {
//            result.append(firstValue);
//        }
//
//        int progression = firstValue;
//        for (int i = 1; i < length; i++) {
//            progression += step;
//            if (i == indexOfRemove) {
//                result.append(" ..");
//                answer = progression;
//                continue;
//            }
//            result.append(String.format(" %d", progression));
//        }
//
//        return result.toString();
//    }
}
