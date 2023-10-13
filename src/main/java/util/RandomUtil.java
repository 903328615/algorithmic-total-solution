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

    //随机生成 int arr 数组 长度不超过 maxLength 最大值不超过 maxNum
    public static int[] generateArray(int maxLength, int maxNum) {
        int length = random.nextInt(maxLength) + 1;
        int[] arr = new int[length];
        if (maxNum <= 0) {
            return arr;
        }
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(maxNum);
        }
        return arr;
    }

}
