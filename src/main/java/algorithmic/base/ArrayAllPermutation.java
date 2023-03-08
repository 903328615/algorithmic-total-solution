package algorithmic.base;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-20
 **/
public class ArrayAllPermutation {

    public static void permutation(int[] array) {
        permutation(array, 0);
    }

    public static void permutation1(int[] array) {
        permutation(array, 1);
    }
    private static void permutation(int[] array, int start) {
        if (start == array.length) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; i++) {
                // 首次进来 0-0 交换
                swap(array, start, i);
                permutation(array, start + 1);
                // 恢复现场
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int numOfWays(int[] nums) {
        // 暴力解法，全排列，计算每个排列的搜索二叉树是否相同
        // 首个元素必然要相等
        return 0;
    }

    public static void main(String[] args) {
        permutation(new int[]{1,2,3});
    }
}

