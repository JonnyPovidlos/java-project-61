package hexlet.code;

import java.util.Random;

public interface IGame {
    String getIntroducingPhrase();
    String getQuestion(Random generator);
    String getAnswer();
}
