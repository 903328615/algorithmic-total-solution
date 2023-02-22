package util;

import java.util.Arrays;

public class CommonUtil {

    public static int[] copyArr(int[] og) {
        return Arrays.copyOf(og, og.length);
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }
}
