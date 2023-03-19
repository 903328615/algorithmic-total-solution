package algorithmic.total.solution.leetcode;

import java.util.Arrays;

public class Question213Byte {

    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        // 不可相邻
        int max = 0;
        // index
        max = Math.max(process(nums, 0, dp), process(nums, 1, dp));
        max = Math.max(max, nums[nums.length - 1]);
        System.out.println(Arrays.toString(dp));
        return max;
    }

    // index 开始偷的情况下的最大金额
    public static int process(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == nums.length - 1) {
            dp[index] = nums[index];
            return dp[index];
        }
        dp[index] = Math.max(process(nums, index + 1, dp),
                nums[index] + process(nums, index + 2, dp));
        return dp[index];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 1, 1}));
    }
}
