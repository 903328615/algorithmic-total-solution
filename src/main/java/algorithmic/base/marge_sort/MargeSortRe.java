package algorithmic.base.marge_sort;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-02
 **/
public class MargeSortRe {

    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    // [start,end] 范围进行排序
    private static void doSort(int[] arr, int start, int end) {
        if (arr == null || start == end) {
            return;
        }
        // 0 10 10+
        int mid = start + ((end - start) >> 1);
        doSort(arr, start, mid);
        doSort(arr, mid + 1, end);
        marge(arr, start, mid, end);
    }

    private static void marge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int h = 0;
        while (i <= mid && j <= end) {
            help[h++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            help[h++] = arr[i++];
        }
        while (j <= end) {
            help[h++] = arr[j++];
        }
        i = 0;
        for (j = start; j <= end; j++) {
            arr[j] = help[i++];
        }
    }

}

