package cakes.util;

import java.util.Random;

public class Helper {

    static Random sc = new Random();

    public static int getRandom(int max){
        return sc.nextInt(max);
    }
    public static int getRandom(int min, int max){
        return sc.nextInt(min, max);
    }

}
