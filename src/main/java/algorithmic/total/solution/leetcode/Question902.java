package algorithmic.total.solution.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * 示例 1：
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * @author: wangzibin
 * @create: 2023-03-08
 **/
public class Question902 {


    public static int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length < 1) {
            return 0;
        }
        int[] digitsNum = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitsNum[i] = Integer.parseInt(digits[i]);
        }
        int maxWei = String.valueOf(n).length() - 1;
        // 对于数字 n 0 - wei 位数符合条件的
        // 1921
        //位 0 1 2 3
        // 需要两个 dp[] 表
        return process(digitsNum, n, maxWei, false) + process(digitsNum, n, maxWei, true);
    }

    public static int atMostNGivenDigitSet2(String[] digits, int n) {
        if (digits == null || digits.length < 1) {
            return 0;
        }
        int[] digitsNum = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitsNum[i] = Integer.parseInt(digits[i]);
        }
        // dp[0][i] 小于
        // dp[1][i] 等于
        int maxWei = String.valueOf(n).length() - 1;
        int[][] dp = new int[2][maxWei + 1];
        int wie0 = getWie(n, 0);
        for (int i = 0; i < digitsNum.length; i++) {
            if (digitsNum[i] < wie0) {
                dp[0][0]++;
            } else if (digitsNum[i] == wie0) {
                dp[1][0]++;
            }
        }
        // k 位 nk
        for (int i = 1; i <= maxWei; i++) {
            int weiNum = getWie(n, i);
            // 0 - wei-1 有多少符合条件的值
            int pre = dp[0][i - 1];
            int preEq = dp[1][i - 1];
            int low = 0;
            int eqNum = 0;
            for (int j = 0; j < digits.length; j++) {
                if (digitsNum[j] < weiNum) {
                    low++;
                } else if (digitsNum[j] == weiNum) {
                    eqNum++;
                }
            }
            dp[1][i] = eqNum * preEq;
            dp[0][i] = digits.length + digits.length * pre + low * preEq;
        }
        // 对于数字 n 0 - wei 位数符合条件的
        // 1921
        //位 0 1 2 3
        // 需要两个 dp[] 表
        return dp[0][maxWei] + dp[1][maxWei];
    }

    private static int process(int[] digits, int n, int wei, boolean eq) {
        int weiNum = getWie(n, wei);
        int result = 0;
        if (wei == 0) {
            for (int i = 0; i < digits.length; i++) {
                if (!eq && digits[i] < weiNum) {
                    result++;
                } else if (eq && digits[i] == weiNum) {
                    result++;
                }
            }
            return result;
        }

        // 0 - wei-1 有多少符合条件的值
        int pre = process(digits, n, wei - 1, eq);
        int low = 0;
        int eqNum = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < weiNum) {
                low++;
            } else if (eq && digits[i] == weiNum) {
                eqNum++;
            }
        }
        if (eq) {
            result = eqNum * pre;
        } else {
            int preEq = process(digits, n, wei - 1, true);
            // 两位的时候，已知 数组 <10 所以 digits.length 个数小于
            result = digits.length + digits.length * pre + low * preEq;
        }

        return result;
    }

    private static int getWie(int num, int wei) {

        String number = String.valueOf(num);
        if (wei >= number.length()) {
            System.out.println("fuck");
            return -1;
        }
        return Integer.parseInt(String.valueOf(number.charAt(wei)));
    }


    public static void main(String[] args) {

        System.out.println(atMostNGivenDigitSet(new String[]{"3", "7"}, 100));
        System.out.println(atMostNGivenDigitSet2(new String[]{"3", "7"}, 100));

    }

}

