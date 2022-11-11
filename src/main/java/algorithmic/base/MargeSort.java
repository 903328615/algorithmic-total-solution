package algorithmic.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-11-10
 **/
public class MargeSort {

    public static void sort(int[] arr) {
        processSort(arr, 0, arr.length - 1);
    }

    // 递归含义 使 [L,R] 范围有序
    public static void processSort(int[] arr, int L, int R) {
        if (arr.length < 2 || L == R) {
            // 结束条件
            return;
        }
        int mid = L + ((R - L) >> 1);
        processSort(arr, L, mid);
        processSort(arr, mid + 1, R);
        marge(arr, L, mid, R);

    }

    /**
     * @Description: 合并 [L ,mid] [mid+1,R] 两个有序数组
     * @Param arr
     * @Param L
     * @Param mid
     * @Param R
     * @Return void
     */
    private static void marge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int lStart = L;
        int rStart = mid + 1;
        int i = 0;
        while (lStart <= mid && rStart <= R) {
            help[i++] = arr[lStart] < arr[rStart] ? arr[lStart++] : arr[rStart++];
        }
        while (lStart <= mid) {
            help[i++] = arr[lStart++];
        }
        while (rStart <= R) {
            help[i++] = arr[rStart++];
        }
        i = 0;
        for (int j = L; j <= R; j++) {
            arr[j] = help[i++];
        }
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
                if (arr[k]!=arr2[k]){
                    System.out.println("error");
                    return;
                }
            }
        }
        System.out.println("success");
    }

}

