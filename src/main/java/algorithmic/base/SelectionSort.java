package algorithmic.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2022-10-31
 **/
public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = new int[]{4, 3, 21, 5, 6, 7, 9};
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(minIndex, i, arr);
        }

    }

    void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

