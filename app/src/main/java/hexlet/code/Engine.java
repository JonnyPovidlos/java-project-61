package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final String QUESTION_PATTERN = "Question: %s\nYour answer: ";
    public static final String CORRECT_PHRASE = "Correct!";
    public static final String LOSE_PHRASE = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    public static final String WIN_PHRASE = "Congratulations, %s!";


    public static void run(String[][] questionsAndAnswers, String introducingPhrase) {
        var input = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String player = input.next();
        System.out.printf("Hello, %s!\n", player);


        System.out.println(introducingPhrase);

        for (String[] questionsAndAnswer : questionsAndAnswers) {
            var question = questionsAndAnswer[0];
            var answer = questionsAndAnswer[1];

            var questionPhrase = String.format(QUESTION_PATTERN, question);

            System.out.printf(questionPhrase, question);
            var playerAnswer = input.next();

            if (!playerAnswer.equals(answer)) {
                System.out.printf(LOSE_PHRASE, playerAnswer, answer, player);
                return;
            }

            System.out.println(CORRECT_PHRASE);
        }

        System.out.printf(WIN_PHRASE, player);
    }
}
