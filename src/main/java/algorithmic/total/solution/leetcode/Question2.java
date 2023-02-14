package algorithmic.total.solution.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithmic-total-solution
 * @description: 可整合数组：如果一个数组在排序之后，相邻的两个数的差值的觉得值为 1 ，则认为该数组为可整合数组。
 * 如 [1,5,4,2,3] 排序后为 [1,2,3,4,5] 则该数组即符合为可整合数组
 * <p>
 * 给定一个整形数组 arr ，返回其中最大可整合子数组长度。
 * 如 [9,20,1,5,4,2,3] 最大可整合子数组为 [1,5,4,2,3] 则返回 5
 * @author: wangzibin
 **/
public class Question2 {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 20, 1, 5, 4, 2, 3};
        System.out.println(getMaxSubIntegrationArray(arr));
    }


    private static int getMaxSubIntegrationArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int num = 1;
        // 计算子数组是否有重复元素
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            // 每次更换开头清空
            int max = arr[i];
            int min = arr[i];
            numSet.clear();
            for (int j = i; j < arr.length; j++) {
                int currValue = arr[j];
                if (numSet.contains(currValue)) {
                    break;
                }
                max = Math.max(currValue, max);
                min = Math.min(currValue, min);
                int distance = max - min;
                int length = j - i + 1;
                if ((j - i) == distance && num < length) {
                    num = length;
                }
                numSet.add(currValue);
            }
        }
        return num;
    }
}

