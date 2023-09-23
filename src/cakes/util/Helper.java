package cakes.util;

import java.util.Random;

public class Helper {

    Random sc = new Random();

    public int getRandom(int max){
        return sc.nextInt(max);
    }
    public int getRandom(int min, int max){
        return sc.nextInt(min, max);
    }

}
