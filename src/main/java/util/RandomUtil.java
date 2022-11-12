package util;

import java.util.Random;

public class RandomUtil {

    private final static Random random = new Random();

    public static int[] randomArr(int len) {
        int[] arr = new int[len];

        for (int j = 0; j < len; j++) {
            int item = random.nextInt(100);
            arr[j] = item;
        }
        return arr;
    }

    public static int[] randomArr() {
        int len = random.nextInt(20) + 5;
        return randomArr(len);
    }

}
