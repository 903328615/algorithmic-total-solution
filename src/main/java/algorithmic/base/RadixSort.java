package algorithmic.base;

import util.RandomUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-11-28
 **/
public class RadixSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        int digit = 0;
        for (int i = 0; i < len; i++) {
            digit = Math.max(digit, getDigitNum(arr[i]));
        }
        int[] help = new int[len];
        for (int i = 0; i < digit; i++) {
            int[] count = new int[10];
            // 计算 i 位 等于 j 的有多少
            for (int j = 0; j < len; j++) {
                count[getDigit(arr[j], i)]++;
            }
            // 计算出 i 位 小于等于 j 的有多少
            for (int j = 1; j < 10; j++) {
                count[j] = count[j] + count[j - 1];
            }

            for (int j = len - 1; j >= 0; j--) {
                // 模拟先进先出，
                int currentD = getDigit(arr[j], i);
                int num = count[currentD];
                help[num - 1] = arr[j];
                count[currentD]--;
            }
            for (int j = 0; j < len; j++) {
                arr[j] = help[j];
            }
        }

    }

    private static int getDigitNum(int num) {
        int i = 0;
        while (num > 0) {
            num /= 10;
            i++;
        }
        return i;
    }

    private static int getDigit(int num, int digit) {
        for (int i = 0; i < digit; i++) {
            num /= 10;
        }
        return num % 10;
    }

    public static void main(String[] args) {
        int[] arr;
        int[] arr2;
        SelectionSort selectionSort = new SelectionSort();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int len = random.nextInt(20) + 5;
            arr = new int[len];
            arr2 = new int[len];
            for (int j = 0; j < len; j++) {
                int item = random.nextInt(100);
                arr[j] = item;
                arr2[j] = item;
            }
            sort(arr);
            selectionSort.sort(arr2);
            for (int k = 0; k < len; k++) {
                if (arr[k] != arr2[k]) {
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arr2));
                    System.out.println("error " + i);
                    return;
                }
            }
        }
        System.out.println("success");
    }
}

