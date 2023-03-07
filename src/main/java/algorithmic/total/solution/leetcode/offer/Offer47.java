package algorithmic.total.solution.leetcode.offer;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-20
 **/
public class Offer47 {

    public static int maxValue(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < w; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[h - 1][w - 1];
    }

    public static void main(String[] args) {
        // 1 2 5
        // 3 2 1
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        System.out.println(maxValue(grid));
    }
}

