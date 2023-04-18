package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * @author: wangzibin
 * @create: 2023-04-04
 **/
public class Question416 {

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        total = total / 2;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = total; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[total];
    }

    private static boolean process(int start, int leftSum, int[] nums, int[] sum) {

        if (start == nums.length) {
            return leftSum == sum[sum.length - 1] - leftSum;
        }

        return process(start + 1, leftSum + nums[start], nums, sum) || process(start + 1, leftSum, nums, sum);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 5, 4, 5}));
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));
        // 12 = 6
    }
}

