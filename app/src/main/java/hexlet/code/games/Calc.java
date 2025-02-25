package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {
    public static final String INTRODUCING_PHRASE = "What is the result of the expression?";

    private static final String QUESTION_PHRASE = "%d %s %d";
    private static final int MAX_OPERANDS_VALUE = 100;
    private static final String[] AVAILABLE_OPERATORS = {"+", "-", "*"};
    private static final int MAX_ROUNDS = 3;

    public static void run() {
        var questionsAndAnswers = generate(MAX_ROUNDS, MAX_OPERANDS_VALUE, AVAILABLE_OPERATORS);

        Engine.run(questionsAndAnswers, INTRODUCING_PHRASE);
    }

    private static String[][] generate(int rounds, int maxOperandValue, String[] availableOparators) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int operand1 = Utils.getRandomInt(0, maxOperandValue);
            int operand2 = Utils.getRandomInt(0, maxOperandValue);
            int operatorIndex = Utils.getRandomInt(0, availableOparators.length);
            String operator = availableOparators[operatorIndex];

            result[i][0] = String.format(QUESTION_PHRASE, operand1, operator, operand2);
            result[i][1] = Integer.toString(calculate(operand1, operand2, operator));
        }


        return result;
    }

    private static Integer calculate(int operand1, int operand2, String operator) {

        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            default:
                return null;
        }
    }
}

