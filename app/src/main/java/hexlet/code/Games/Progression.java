package hexlet.code.Games;

import hexlet.code.IGame;

import java.util.Random;

public class Progression implements IGame {

    private int answer;

    private static final String INTRODUCING_PHRASE = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_GENERATOR = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_FIRST_VALUE = 10;


    public String getIntroducingPhrase() {
        return INTRODUCING_PHRASE;
    }
    public String getQuestion(Random generator) {
        int length = generator.nextInt(MAX_GENERATOR) + MIN_LENGTH;
        int indexOfRemove = generator.nextInt(length);
        int step = generator.nextInt(1, MAX_STEP);
        int firstValue = generator.nextInt(MAX_FIRST_VALUE);

        StringBuilder result = new StringBuilder();
        if (indexOfRemove == 0) {
            result.append("..");
            answer = firstValue;
        } else {
            result.append(firstValue);
        }

        int progression = firstValue;
        for (int i = 1; i < length; i++) {
            progression += step;
            if (i == indexOfRemove) {
                result.append(" ..");
                answer = progression;
                continue;
            }
            result.append(String.format(" %d", progression));
        }

        return result.toString();
    }
    public String getAnswer() {
        return Integer.toString(answer);
    }
}
