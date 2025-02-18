package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Calc {
    public static final String INTRODUCING_PHRASE = "What is the result of the expression?";

    private static final String QUESTION_PHRASE = "%d %s %d";
    private static final String[] AVAILABLE_OPERATORS = {"+", "-", "*"};

    public static void run(String player, Scanner in, int rounds, int maxOperandsValue) {
        var generator = new Random();

        var questionsAndAnswers = generate(rounds, generator, maxOperandsValue);

        Engine.run(player, questionsAndAnswers, INTRODUCING_PHRASE, in);
    }

    private static String[][] generate(int rounds, Random generator, int maxOperandsValue) {
        var result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int operand1 = generator.nextInt(maxOperandsValue);
            int operand2 = generator.nextInt(maxOperandsValue);
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

