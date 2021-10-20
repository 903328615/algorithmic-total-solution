package algorithmic.total.solution.common;

/**
 * @program: algorithmic-total-solution
 * @description: 买卖股票的最佳时机
 * 给定一个数组 arr 长度为 N，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔 交易。
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author: wangzibin
 * @create: 2021-09-16
 **/
public class Question4 {

    public static void main(String[] args) {
        int[] price=new int[]{9,3,4,9,5,1};
        System.out.println(getMaxProfit(price,2));
    }


    public static int getMaxProfit(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int length = arr.length;
        if (k >= length / 2) {
            return getMaxProfit(arr);
        } else {
            int[][] dp = new int[length][k + 1];

            for (int j = 1; j < k + 1; j++) {
                int preMax = dp[0][j-1]-arr[0];
                for (int i = 1; i < length; i++) {
                    preMax = Math.max(preMax, dp[i][j - 1] - arr[i]);
                    dp[i][j] = Math.max(preMax + arr[i], dp[i - 1][j]);
                }
            }
            return dp[length - 1][k];
        }
    }

    private static int getMaxProfit(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int buy = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[buy] < arr[i]) {
                sum += arr[i] - arr[buy];
            }
            buy = i;
        }
        return sum;
    }

}

