package hexlet.code.Games;

import hexlet.code.IGame;

import java.util.Random;

public final class Gcd implements IGame {

    private int answer;

    private static final String INTRODUCING_PHRASE = "Find the greatest common divisor of given numbers.";
    private static final String QUESTION_PHRASE = "%s %s";
    private static final int MAX_OPERANDS_VALUE = 100;

    public String getIntroducingPhrase() {
        return INTRODUCING_PHRASE;
    }

    public String getQuestion(Random generator) {
        int operand1 = generator.nextInt(MAX_OPERANDS_VALUE);
        int operand2 = generator.nextInt(MAX_OPERANDS_VALUE);

        answer = findGCD(operand1, operand2);


        return String.format(QUESTION_PHRASE, operand1, operand2);
    }
    public String getAnswer() {
        return Integer.toString(answer);
    }

    private static int findGCD(int operand1, int operand2) {
        int tmp;

        while (operand2 != 0) {
            tmp = operand1 % operand2;
            operand1 = operand2;
            operand2 = tmp;
        }
        return operand1;
    }
}
