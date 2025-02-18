package hexlet.code.games;

import java.util.Random;

public final class Calc {
    public static final String INTRODUCING_PHRASE = "What is the result of the expression?";

    private static final String QUESTION_PHRASE = "%d %s %d";
    private static final String[] AVAILABLE_OPERATORS = {"+", "-", "*"};
    private static final int MAX_OPERANDS_VALUE = 100;

    public static String[][] generate(int rounds, Random generator) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int operand1 = generator.nextInt(MAX_OPERANDS_VALUE);
            int operand2 = generator.nextInt(MAX_OPERANDS_VALUE);
            int operatorIndex = generator.nextInt(AVAILABLE_OPERATORS.length);
            String operator = AVAILABLE_OPERATORS[operatorIndex];

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

