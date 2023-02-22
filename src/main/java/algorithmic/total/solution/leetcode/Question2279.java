package algorithmic.total.solution.leetcode;

import java.util.Arrays;

/**
 * @program: algorithmic-total-solution
 * @description: 2279. 装满石头的背包的最大数量
 * @author: wangzibin
 * @create: 2023-02-22
 **/
public class Question2279 {


    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        int length = rocks.length;
        for (int i = 0; i < length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for (int i = 0; i < length; i++) {
            if (capacity[i] != 0 && additionalRocks <= 0) {
                break;
            }
            if (capacity[i] == 0) {
                result++;

            } else if (additionalRocks >= capacity[i]) {
                additionalRocks -= capacity[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] capacity = new int[]{2, 3, 4, 5};
        int[] rocks = new int[]{1, 2, 4, 4};
        System.out.println(maximumBags(capacity, rocks, 2));
        System.out.println(Arrays.toString(capacity));
    }
}

