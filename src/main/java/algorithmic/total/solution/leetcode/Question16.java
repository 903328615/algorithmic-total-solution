package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * @author: wangzibin
 * @create: 2023-07-10
 **/
public class Question16 {

    // 三指针 + 排序
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = 100000;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (result == target) {
                    return result;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
                if (sum > target){
                    k--;
                }else {
                    j++;
                }

            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

}

