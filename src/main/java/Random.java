import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 28.10.17 13:41
 * Copyright © LLP JazzSoft
 */
public class Random {
    public static int randomInt(int min, int max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
}
