package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Gcd {
    public  static final String INTRODUCING_PHRASE = "Find the greatest common divisor of given numbers.";

    private static final String QUESTION_PHRASE = "%d %d";
    private static final int MAX_OPERANDS_VALUE = 100;
    private static final int MAX_ROUNDS = 3;

    public static void run() {

        var questionsAndAnswers = generate(MAX_ROUNDS, MAX_OPERANDS_VALUE);

        Engine.run(questionsAndAnswers, INTRODUCING_PHRASE);
    }

    private static String[][] generate(int rounds, int maxOperandsValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int operand1 = Utils.getRandomInt(0, maxOperandsValue);
            int operand2 = Utils.getRandomInt(0, maxOperandsValue);

            result[i][0] = String.format(QUESTION_PHRASE, operand1, operand2);
            result[i][1] = Integer.toString(findGCD(operand1, operand2));
        }

        return result;
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
