package algorithmic.total.solution.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-21
 **/
public class Offer31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed == null || popped == null) {
            return false;
        }
        if (popped.length == 0 && pushed.length == 0) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        stack.push(pushed[i++]);
        int j = 0;
        while (i < pushed.length || !stack.empty()) {
            // 首先先入站直到找到第一个可以 pop 的数
            while (i < pushed.length && (stack.empty() || popped[j] != stack.peek())) {
                stack.push(pushed[i++]);
            }
            // 找不到直接返回
            if (popped[j] != stack.peek()) {
                return false;
            }
            // 找到了 弹出到不能弹为止
            while (!stack.empty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return j >= pushed.length;
    }

    public static void main(String[] args) {
        int[] push = new int[]{0, 1};
        int[] pop = new int[]{0, 1};
        System.out.println(validateStackSequences(push, pop));
    }
}

