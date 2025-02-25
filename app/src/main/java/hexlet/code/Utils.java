package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int min, int max) {
        var generator = new Random();
        return generator.nextInt(max) + min;
    }
}
