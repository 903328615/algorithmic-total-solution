package algorithmic.base.marge_sort;

import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;

// 数组最小和问题，归并排序应用
public class MargeSortGetMinSum {


    public static int processSortGetMin(int[] arr, int L, int R) {
        if (arr.length < 2 || L == R) {
            // 结束条件
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        int lMin = processSortGetMin(arr, L, mid);
        int rMin = processSortGetMin(arr, mid + 1, R);
        int mMin = margeGetMinSum(arr, L, mid, R);
        return mMin + lMin + rMin;

    }

    // 获取小和
    private static int margeGetMinSum(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int lStart = L;
        int rStart = mid + 1;
        int result = 0;
        int i = 0;
        while (lStart <= mid && rStart <= R) {

            if (arr[lStart] < arr[rStart]) {
                int current = help[i++] = arr[lStart++];
                // 抽象为右组有多少个数比当前数大，可以省去遍历相加
                result += current * (R - rStart + 1);
            } else {
                // 相等时，先入右组数，更新游标
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
        return result;
    }

    public static int getMinSum(int[] arr) {
        return processSortGetMin(arr, 0, arr.length - 1);
    }

    public static int getMinSumSimple(int[] arr) {
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int[] arr = RandomUtil.randomArr();
            int[] arr2 = CommonUtil.copyArr(arr);
            int[] arr3 = CommonUtil.copyArr(arr);
            int minSumSimple = getMinSumSimple(arr);
            int minSum = getMinSum(arr2);
            if (minSum != minSumSimple) {
                System.out.println(Arrays.toString(arr3));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr));
                System.out.println("error marge=" + minSum + " simple=" + minSumSimple);
                return;
            }
        }
        System.out.println("success");

    }

}
