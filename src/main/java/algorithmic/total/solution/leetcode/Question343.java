package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * @author: wangzibin
 * @create: 2023-04-07
 **/
public class Question343 {

    public static int integerBreak(int n) {
        // 暴力的是遍历所有组合

        return process(0, 0, n);
    }

    private static int process(int use, int sum, int n) {
        if (use == n) {
            return sum;
        }
        return 0;
    }
}

