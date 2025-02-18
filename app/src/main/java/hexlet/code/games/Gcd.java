package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Gcd {
    public  static final String INTRODUCING_PHRASE = "Find the greatest common divisor of given numbers.";

    private static final String QUESTION_PHRASE = "%d %d";

    public static void run(String player, Scanner in, int rounds, int maxOperandsValue) {
        var generator = new Random();

        var questionsAndAnswers = generate(rounds, generator, maxOperandsValue);

        Engine.run(player, questionsAndAnswers, INTRODUCING_PHRASE, in);
    }

    private static String[][] generate(int rounds, Random generator, int maxOperandsValue) {
        String[][] result = new String[rounds][2];

        for (int i = 0; i < rounds; i++) {
            int operand1 = generator.nextInt(maxOperandsValue);
            int operand2 = generator.nextInt(maxOperandsValue);

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
