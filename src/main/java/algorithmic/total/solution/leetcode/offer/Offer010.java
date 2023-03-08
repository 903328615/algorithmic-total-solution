package algorithmic.total.solution.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * 示例 1：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * @author: wangzibin
 * @create: 2023-03-07
 **/
public class Offer010 {

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        // 前缀和 ， 前缀和数目  1，2,3-4,5,6
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        int result = 0;
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            // preSum - k 这个相当于找当前位置的之前所有子串，有没有 和 为 k 的子串
            if (cache.containsKey(preSum - k)) {
                result += cache.get(preSum - k);
            }
            cache.put(preSum, cache.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 3}, 3));
    }

}

