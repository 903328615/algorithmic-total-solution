package algorithmic.base.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: algorithmic-total-solution
 * @description: 最长公共子序列
 * @author: wangzibin
 * @create: 2023-03-06
 **/
public class MaxSubString {


    public static int maxSubString(String s1, String s2) {

        if (StringUtils.isBlank(s1) || StringUtils.isBlank(s2)) {
            return 0;
        }
        // dp 样本做行 ，样本做列 的尝试模型
        int high = s1.length();
        int width = s2.length();
        int[][] dp = new int[high][width];
        // dp[i][j] i,j 位置结尾的字符串 s1 s2 的最常公共子序列长度
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < high; i++) {
            dp[i][0] = dp[i - 1][0] == 1 || s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }
        for (int j = 1; j < width; j++) {
            dp[0][j] = dp[0][j - 1] == 1 || s1.charAt(0) == s2.charAt(j) ? 1 : 0;
        }
        // 对于一般位置
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[high - 1][width - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubString("abssd143567", "14jjnnxxs356yyyyhi7"));
        System.out.println(maxSubString("123", "qwe"));
    }


}

