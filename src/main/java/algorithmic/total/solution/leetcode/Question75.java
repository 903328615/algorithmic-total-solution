package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * @author: wangzibin
 * @create: 2023-04-03
 **/
public class Question75 {

    public static void sortColors(int[] nums) {
        // nlogn 以 O(n) 的复杂度解决
        // 采用快排分区的思路 ，一次分区即可解决
        if (nums == null || nums.length < 2) {
            return;
        }
        int target = 1;
        int red = -1;
        int blue = nums.length;
        int index = 0;
        while (index < blue) {
            if (nums[index] < target) {
                swap(index, ++red, nums);
                index++;
            } else if (nums[index] > target) {
                swap(index, --blue, nums);
            } else {
                index++;
            }
        }

    }

    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

