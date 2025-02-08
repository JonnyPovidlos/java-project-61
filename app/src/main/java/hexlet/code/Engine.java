package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    private final IGame game;
    private final String player;
    private final Random generator;

    public static final int MAX_ROUNDS = 3;
    public static final String QUESTION_PATTERN = "Question: %s\nYour answer: ";
    public static final String CORRECT_PHRASE = "Correct!";
    public static final String LOSE_PHRASE = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    public static final String WIN_PHRASE = "Congratulations, %s!";

    Engine(IGame game, String player) {
        this.game = game;
        this.player = player;
        this.generator = new Random();
    }

    public void run(Scanner in) {
        System.out.println(game.getIntroducingPhrase());
        int counter = 0;

        while (counter < MAX_ROUNDS) {
            String question = game.getQuestion(generator);

            System.out.printf(QUESTION_PATTERN, question);

            String answer = in.next();

            if (!answer.equals(game.getAnswer())) {
                System.out.printf(LOSE_PHRASE, answer, game.getAnswer(), player);
                return;
            }

            System.out.println(CORRECT_PHRASE);
            counter += 1;
        }

        System.out.printf(WIN_PHRASE, player);
    }
}
