package algorithmic.base.marge_sort;

import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;

//**逆序对问题**
//
//在一个数组中，任意 i 位置数 对于任意后置位的数如果大于则与该数组成一个逆序对，给定一个数组求数组中有多少逆序对
//
//```java
//如对于数组 [1,3,4,5,2]
//逆序对有 [3,2] [4,2] [5,2] 结果为 3
//```
public class MargeSortReversePair {


    public static int reversePairNumSimple(int[] arr) {
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    num++;
                }
            }
        }
        return num;
    }


    public static int reversePairNum(int[] arr) {
        return processSort(arr, 0, arr.length - 1);
    }

    // 递归含义 使 [L,R] 范围有序
    public static int processSort(int[] arr, int L, int R) {
        if (arr.length < 2 || L == R) {
            // 结束条件
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return processSort(arr, L, mid) +
                processSort(arr, mid + 1, R) +
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
    private static int marge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int lStart = L;
        int rStart = mid + 1;
        int i = 0;
        int num = 0;
        while (lStart <= mid && rStart <= R) {
            if (arr[lStart] <= arr[rStart]) {
                // 相等时，先入左组数，更新游标
                help[i++] = arr[lStart++];
            } else {
                // 抽象为左组有多少个数比当前数大
                num += (mid - lStart + 1);
                help[i++] = arr[rStart++];
            }
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
        return num;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            int[] arr = RandomUtil.randomArr();
            int[] arr2 = CommonUtil.copyArr(arr);
            int reversePairNum = reversePairNum(arr);
            int reversePairNumSimple = reversePairNumSimple(arr2);
            if (reversePairNum != reversePairNumSimple) {
                System.out.println(Arrays.toString(arr2));
                System.out.println("error reversePairNum=" + reversePairNum +
                        " reversePairNumSimple=" + reversePairNumSimple);
                return;
            }
        }
        System.out.println("success");
    }
}
