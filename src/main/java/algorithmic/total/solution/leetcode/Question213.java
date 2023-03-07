package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-07
 **/
public class Question213 {
    public static int rob2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        // 选首个
        int dp1a = 0;
        int dp1b = nums[n - 2];
        int max1 = dp1b;
        // 不选首个
        int dp2a = nums[n - 1];
        int dp2b = Math.max(nums[n - 2], nums[n - 1]);
        int max2 = dp2b;
        for (int i = n - 3; i >= 0; i--) {
            max1 = Math.max(nums[i] + dp1a, dp1b);
            dp1a = dp1b;
            dp1b = max1;
        }
        for (int i = n - 3; i > 0; i--) {
            max2 = Math.max(nums[i] + dp2a, dp2b);
            dp2a = dp2b;
            dp2b = max2;
        }
        return Math.max(max1, max2);
    }

    public static int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
            dp2[i] = -1;
        }
        // 不可相邻
        int max = 0;
        // index 这里因为成环，不管任何位置，只有三种讨论 用当前位置，和不用当前位置
        max = Math.max(process(nums, 0, true, dp, dp2), process(nums, 1, false, dp, dp2));
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));
        return max;
    }

    // index 开始偷的情况下的最大金额
    public static int process(int[] nums, int index, boolean useFirst, int[] dp, int[] dp2) {
        if (index >= nums.length) {
            return 0;
        }
        int[] thisDp = useFirst ? dp : dp2;

        if (thisDp[index] != -1) {
            return thisDp[index];
        }
        if (index == nums.length - 1) {
            thisDp[index] = useFirst ? 0 : nums[index];
            return thisDp[index];
        }
        thisDp[index] = Math.max(process(nums, index + 1, useFirst, dp, dp2),
                nums[index] + process(nums, index + 2, useFirst, dp, dp2));
        return thisDp[index];
    }

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{1, 3, 1, 3, 100}));
        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));
    }
}

