package algorithmic.base.quick_sort;

import algorithmic.base.marge_sort.MargeSort;
import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static final Random random = new Random();

    public static void sort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    // [L,R] 范围有序
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] pair = partition(arr, L, R);
        process(arr, L, pair[0] - 1);
        process(arr, pair[1] + 1, R);
    }

    // 在 [L,R] 上进行分区 返回等于区下标
    public static int[] partition(int[] arr, int L, int R) {
        if (L > R){
            return new int[]{-1, -1};
        }
        if (L == R){
            return new int[]{L, R};
        }
        // 小于区下标
        int minEqIndex = L - 1;
        // 大于区下标
        int maxEqIndex = R;
        int index = L;
        // 随机取一个数
        int some = random.nextInt(R - L + 1) + L;
        swap(arr, some, R);
        while (index < maxEqIndex) {
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++minEqIndex);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --maxEqIndex);
            } else {
                index++;
            }
        }
        swap(arr, R, maxEqIndex);
        return new int[]{minEqIndex + 1, maxEqIndex};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] arr = RandomUtil.randomArr();
            int[] arr2 = CommonUtil.copyArr(arr);
            MargeSort.sort(arr);
            sort(arr2);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != arr2[j]) {
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arr2));
                    System.out.println("error");
                    return;
                }
            }
        }
        System.out.println("success");
    }
}
