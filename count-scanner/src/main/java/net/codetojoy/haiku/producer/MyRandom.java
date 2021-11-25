package net.codetojoy.haiku.producer;

import java.util.concurrent.ThreadLocalRandom;

public class MyRandom {
    int get(int max) {
        int min = 1;
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }
}
