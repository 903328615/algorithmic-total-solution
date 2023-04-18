package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description: 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * @author: wangzibin
 * @create: 2023-04-17
 **/
public class Question50 {
    public static void main(String[] args) {
        System.out.println(myPow(2d, 10));
        System.out.println(myPow(2.1d, 3));
        System.out.println(myPow(2d, -2));
        System.out.println(Math.pow(0.00001, 2147483647));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2, -2147483648));
        System.out.println(myPow(-1, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (x == 1 || x == 0 || n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n < -100) {
            return 0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return quickMul(x,n);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) { return 1.0; }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}

