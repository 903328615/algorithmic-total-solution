package algorithmic.total.solution.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * @author: wangzibin
 * @create: 2023-05-10
 **/
public class Question907 {

    public final static int s = 1000000000+7;
    public static int sumSubarrayMins(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int right = i;
            // (left,right]
            LinkedList<Long> queue = new LinkedList<>();
            for (; right < arr.length; right++) {
                while (!queue.isEmpty() && queue.peek() > arr[right]) {
                    queue.poll();
                }
                queue.add((long) arr[right]);
                sum += queue.getFirst();
            }
        }
        return Math.toIntExact(sum % s);
    }

    public static void main(String[] args) {
        int sumSubarrayMins = sumSubarrayMins(new int[]{3,1,2,4});
        System.out.println(sumSubarrayMins);
    }
}

