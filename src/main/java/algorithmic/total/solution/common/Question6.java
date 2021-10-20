package algorithmic.total.solution.common;

import com.sun.tools.javac.util.StringUtils;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * @author: wangzibin
 * @create: 2021-10-20
 **/
public class Question6 {


    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {

        if (s == null || t == null) {
            return 0;
        }
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return 0;
        } else if (sLength == tLength) {
            return s.equals(t) ? 1 : 0;
        }
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        // dp[i][j] 含义 s[0-i] 等于 t[0-j] 的子序列个数
        // 那么对于每一个 dp[i][j] 讨论
        // 如果不包含 i 则有 dp[i-1][j] 个
        // 如果 s[i] == t[j] 则 可以包含 i 则为 dp[i-1][j-1]
        // 则动规方程为： dp[i][j] = dp[i-1][j] + s[i] == t[j] ? dp[i-1][j-1] : 0 ;
        int[][] dp = new int[sLength][tLength];
        if (sBytes[0] == tBytes[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < sLength; i++) {
            dp[i][0] = dp[i - 1][0] + (sBytes[i] == tBytes[0] ? 1 : 0);
        }
        for (int j = 1; j < tLength; j++) {
            for (int i = j; i < sLength; i++) {
                dp[i][j] = dp[i - 1][j] + (sBytes[i] == tBytes[j] ? dp[i - 1][j - 1] : 0);
            }
        }

        return dp[sLength - 1][tLength - 1];
    }


}

