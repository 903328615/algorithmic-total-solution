package algorithmic.base.marge_sort;

import algorithmic.base.SelectionSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-11-10
 **/
public class MargeSort {

    // 非递归方法
    public static void sort2(int[] arr) {
        // 合并区域以 1 开始
        int range = 1;
        while (range < arr.length) {
            int start = 0;
            int step = range << 1;

            while (start + range < arr.length) {

                int L = start;
                int mid = start + range - 1;
                int R = Math.min(start + step - 1, arr.length - 1);
                marge(arr, L, mid, R);
                start = R + 1;
            }
            range = step;
        }
    }


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
            sort2(arr);
            MargeSortRe.sort(arr2);
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

