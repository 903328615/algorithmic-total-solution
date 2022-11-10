package algorithmic.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description: 递归方式求数组最大值
 * @author: wangzibin
 * @create: 2022-11-07
 **/
public class FindMaxRecursion {
    // 此递归方法含义，在 [i , j] 范围内寻找最大值
    public static int findMax(int[] arr, int L, int R) {
        if (L >= R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = findMax(arr, L, mid);
        int rightMax = findMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        if (arr.length == 1) {
            return max;
        }
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int[] randomArr() {
        Random random = new Random();
        int length = random.nextInt(100) + 10;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }


    public static void main(String[] arg) {
        for (int i = 0; i < 1000; i++) {
            int[] randomArr = randomArr();
            int max = findMax(randomArr);
            int max1 = findMax(randomArr, 0, randomArr.length - 1);
            if (max != max1) {
                System.out.println("error max=" + max + " max1=" + max1);
                System.out.println(Arrays.toString(randomArr));
                return;
            }
        }
        System.out.println("success");

    }
}

