package algorithmic.total.solution.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author: wangzibin
 * @create: 2023-03-09
 **/
public class Offer42 {

    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int preMin = Math.min(0, nums[0]); // 抓前缀最小
        int max = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(max, total - preMin);
            max = Math.max(max, nums[i]);
            if (preMin > total) {
                preMin = total;
            }
        }
        // 前缀和
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 1, 2, 1}));

        //-2,1,-3,4,-1,2,1,-5,4
        //preMin-2 -2 -4 -4  -4  -4  -4
        //total -2 -1 -4  0  -1  1  2  -3     以 i 结尾
        //max   -2  1  1  4   4  5  6  6
    }

}

