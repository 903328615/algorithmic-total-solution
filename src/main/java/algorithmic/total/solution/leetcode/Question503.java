package algorithmic.total.solution.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-10
 **/
public class Question503 {

    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        // 下一个更大 维护一个 单调栈，递减栈
        for (int i = 0; i < nums.length; i++) {
            // 出栈
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                // 下一个更大就是 nums[i]
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 剩余的再看一圈
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                // 下一个更大就是 nums[i]
                result[stack.pop()] = nums[i];
            }
        }
        // 最后没有的给 -1
        while (!stack.empty()){
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        //输入: nums = [1,2,3,4,3] 输出: [2,3,4,-1,4]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}

