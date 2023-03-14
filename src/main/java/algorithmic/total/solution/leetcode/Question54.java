package algorithmic.total.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-13
 **/
public class Question54 {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        // 收圈
        // [1,  2, 3, 4,5]
        // [14,15,16,17,6]
        // [13,20,19,18,7]
        // [12,11,10, 9,8]

        int highStart = 0;
        int highEnd = matrix.length - 1;
        int widthStart = 0;
        int widthEnd = matrix[0].length - 1;
        while (highStart <= highEnd && widthStart <= widthEnd) {
            int h = highStart, w = widthStart;
            for (w = widthStart; w <= widthEnd; w++) {
                result.add(matrix[h][w]);
            }
            highStart++;
            w = widthEnd;
            for (h = highStart; h <= highEnd; h++) {
                result.add(matrix[h][w]);
            }
            h = highEnd;
            widthEnd--;
            if (highStart <= highEnd && widthStart <= widthEnd) {
                for (w = widthEnd; w >= widthStart; w--) {
                    result.add(matrix[h][w]);
                }
                w = widthStart;
                highEnd--;
                for (h = highEnd; h >= highStart; h--) {
                    result.add(matrix[h][w]);
                }
                widthStart++;
            }

        }
        return result;
    }

    public static void main(String[] args) {

 /*       测试用例:[[1,2,3,4],
                   [5,6,7,8],
                   [9,10,11,12]]
        测试结果:[1,2,3,4,8,12,11,10,9,5,6,7,6]
        期望结果:[1,2,3,4,8,12,11,10,9,5,6,7]*/
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}

