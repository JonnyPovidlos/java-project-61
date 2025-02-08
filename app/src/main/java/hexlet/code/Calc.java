package hexlet.code;

import java.util.Random;

public class Calc implements IGame {

    private int answer;

    private static final String INTRODUCING_PHRASE = "What is the result of the expression?";
    private static final String QUESTION_PHRASE = "%s %s %s";
    private static final String[] AVAILABLE_OPERATORS = {"+", "-", "*"};

    public String getIntroducingPhrase() {
        return INTRODUCING_PHRASE;
    }
    public String getQuestion(Random generator) {
        int operand1 = generator.nextInt(100);
        int operand2 = generator.nextInt(100);
        int operatorIndex = generator.nextInt(3);

        switch (operatorIndex) {
            case 0:
                answer = operand1 + operand2;
                break;
            case 1:
                answer = operand1 - operand2;
                break;
            case 2:
                answer = operand1 * operand2;
                break;
            default:
                break;
        }

        return String.format(QUESTION_PHRASE, operand1, AVAILABLE_OPERATORS[operatorIndex], operand2);
    }

    public String getAnswer() {
        return Integer.toString(answer);
    }
}
