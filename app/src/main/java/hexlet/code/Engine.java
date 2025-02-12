package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final String QUESTION_PATTERN = "Question: %s\nYour answer: ";
    public static final String CORRECT_PHRASE = "Correct!";
    public static final String LOSE_PHRASE = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    public static final String WIN_PHRASE = "Congratulations, %s!";


    public static void run(String player, String[][] questionsAndAnswers, String introducingPhrase, String formatQuestion, Scanner in) {
        System.out.println(introducingPhrase);

        for (String[] questionsAndAnswer : questionsAndAnswers) {
            var question = questionsAndAnswer[0];
            var answer = questionsAndAnswer[1];

            var questionPhrase = String.format(QUESTION_PATTERN, formatQuestion);

            System.out.printf(questionPhrase, question);
            var playerAnswer = in.next();

            if (!playerAnswer.equals(answer)) {
                System.out.printf(LOSE_PHRASE, playerAnswer, answer, player);
                return;
            }

            System.out.println(CORRECT_PHRASE);
        }

        System.out.printf(WIN_PHRASE, player);
    }


//    public void run(Scanner in) {
//        System.out.println(game.getIntroducingPhrase());
//        int counter = 0;
//
//        while (counter < MAX_ROUNDS) {
//            String question = game.getQuestion(generator);
//
//            System.out.printf(QUESTION_PATTERN, question);
//
//            String answer = in.next();
//
//            if (!answer.equals(game.getAnswer())) {
//                System.out.printf(LOSE_PHRASE, answer, game.getAnswer(), player);
//                return;
//            }
//
//            System.out.println(CORRECT_PHRASE);
//            counter += 1;
//        }
//
//        System.out.printf(WIN_PHRASE, player);
//    }
}
