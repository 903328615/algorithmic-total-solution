package algorithmic.total.solution.leetcode.offer;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-08
 **/
public class Offer63 {

    public static int maxProfit(int[] prices) {

        int max = 0;
        if (prices == null || prices.length < 2) {
            return max;
        }
        int buy = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[buy] < prices[i]) {
                max = Math.max(prices[i] - prices[buy], max);
            } else {
                buy = i;
            }
        }
        return max;
    }
}

