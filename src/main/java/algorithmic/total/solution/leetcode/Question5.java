package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个二维数组 matrix ，可以从任何位置出发，每一步可以向上、下、左、右四个方向移动，返回最大递增路径长度。
 * 例子：
 * matrix =
 * 6 5 4
 * 1 2 3
 * 2 7 1
 * 从第二行的 1 出发可形成路径 1 2 3 4 5 6 ，为最长的路径，则答案返回 6.
 * @author: wangzibin
 * @create: 2021-09-29
 **/
public class Question5 {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{6, 5, 4}, {1, 2, 3}, {2, 7, 1}};

        System.out.println(longestIncreasingPath(matrix));
    }

    // 增加缓存
    public static int[][] cache;


    public static int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = process(i, j, matrix);
                if (maxLength < length) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    /**
     * 定义这样一个递归 f(i,j) 从 i,j 位置出发返回最长递增路径长度
     */

    public static int process(int i, int j, int[][] matrix) {

        if (i < 0 || j < 0 || i > matrix.length || j > matrix[0].length) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;

        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            up += process(i, j - 1, matrix);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            down += process(i, j + 1, matrix);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            left += process(i - 1, j, matrix);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            right += process(i + 1, j, matrix);
        }

        int max = Math.max(Math.max(up, down), Math.max(left, right));
        cache[i][j]=max;
        return max;
    }


}

