package algorithmic.base.quick_sort;

import algorithmic.base.marge_sort.MargeSort;
import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;

public class QuickSortSimple {


    public static void sort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    // [L,R] 范围有序
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int m = partition(arr, L, R);
        process(arr, L, m - 1);
        process(arr, m + 1, R);
    }

    // 在 [L,R] 上进行分区 返回等于数的位置
    public static int partition(int[] arr, int L, int R) {
        // 小于等于区下标
        int minEqIndex = L - 1;
        for (int i = L; i <= R; i++) {
            if (arr[i] <= arr[R]) {
                swap(arr, i, ++minEqIndex);
            }
        }
        return minEqIndex;
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
