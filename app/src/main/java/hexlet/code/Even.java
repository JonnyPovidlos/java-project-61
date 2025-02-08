package hexlet.code;

import java.util.Random;

public class Even implements IGame {

    private String answer;

    private static final String INTRODUCING_PHRASE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String QUESTION_PHRASE = "%s";
    private static final int MAX_VALUE = 10000;

    public String getIntroducingPhrase() {
        return INTRODUCING_PHRASE;
    }

    public String getQuestion(Random generator) {
        int number = generator.nextInt(MAX_VALUE);

        answer = (number % 2 == 0) ? "yes" : "no";

        return String.format(QUESTION_PHRASE, number);
    }

    public String getAnswer() {
        return answer;
    }
}
