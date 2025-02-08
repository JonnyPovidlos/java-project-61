package hexlet.code;

import java.util.Random;

public class Prime implements IGame {

    private String answer;

    private static final String INTRODUCING_PHRASE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String QUESTION_PHRASE = "%s";
    private static final int MAX_VALUE = 100;

    public String getIntroducingPhrase() {
        return INTRODUCING_PHRASE;
    }

    public String getQuestion(Random generator) {
        int number = generator.nextInt(1, MAX_VALUE);

        answer = isPrime(number) ? "yes" : "no";

        return String.format(QUESTION_PHRASE, number);
    }

    public String getAnswer() {
        return answer;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i ++){
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
