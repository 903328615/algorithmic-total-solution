package algorithmic.total.solution.common;

import java.util.Collection;
import java.util.Collections;

/**
 * @program: algorithmic-total-solution
 * @description: 拼 M 面值硬币方法（动态规划问题）
 * 现在有 n1 + n2 种面值的硬币，n1 种为普通面值硬币，可以随意取用。n2 种为纪念币，每种最多只能取一个。
 * 每种硬币有一个面值，问：凑满 M 面值有多少种取法？
 * @author: wangzibin
 **/
public class Question1 {


    public static void main(String[] args) {
        int[] arrCommon = new int[]{};
        int[] arrSpecial = new int[]{1,2,5,6,7};
        int targetMoney = 30;
        long num=getMargeMoneyNum(arrCommon, arrSpecial, targetMoney);
        System.out.println("共有 "+num+" 种凑法");
    }

    private static long getMargeMoneyNum(int[] arrCommon, int[] arrSpecial, int targetMoney) {

        int[][] dpCommon = getCoinCommonDp(arrCommon, targetMoney);
        int[][] dpSpecial = getCoinSpecialDp(arrSpecial, targetMoney);
        // 边界检测
        if (dpCommon == null && dpSpecial == null) {
            return targetMoney == 0 ? 1 : 0;
        } else if (dpCommon == null) {
            return dpSpecial[dpSpecial.length - 1][targetMoney];
        } else if (dpSpecial == null) {
            return dpCommon[dpCommon.length - 1][targetMoney];
        }

        long num = 0;
        for (int i = 0; i <= targetMoney; i++) {
            num += (long) dpCommon[arrCommon.length - 1][i] * dpSpecial[arrSpecial.length - 1][targetMoney - i];
        }
        return num;
    }

    /**
     * 普通硬币 dp 表构建
     */
    public static int[][] getCoinCommonDp(int[] arr, int target) {

        if (arr == null || arr.length < 1) {
            return null;
        }

        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            //初始化第一列 凑 0 元
            dp[i][0] = 1;
        }

        for (int j = arr[0]; j < target + 1; j = j + arr[0]) {
            //初始化第一行
            dp[0][j] = 1;
        }

        // 动态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]]

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                int jp = j - arr[i];
                dp[i][j] += jp >= 0 ? dp[i][jp] : 0;
            }
        }

        return dp;
    }

    /**
     * 纪念币 dp 表构建
     */
    public static int[][] getCoinSpecialDp(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            //初始化第一列 凑 0 元
            dp[i][0] = 1;
        }
        // 纪念币只能用一个
        if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

        // 动态转移方程 dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]]

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                int jp = j - arr[i];
                dp[i][j] += jp >= 0 ? dp[i - 1][jp] : 0;
            }
        }

        return dp;
    }

}

