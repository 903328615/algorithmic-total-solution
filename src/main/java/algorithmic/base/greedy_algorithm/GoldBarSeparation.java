package algorithmic.base.greedy_algorithm;

import util.CommonUtil;
import util.RandomUtil;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: algorithmic-total-solution
 * @description: 贪心算法金条分隔问题
 * 给一根长度为 n 的金条，分隔此金条长度为 x, y 两份(x+y =n) 需要和金条长度数值相同的 n 个铜币。
 * 给定一个数组数组和为 n，问最小代价为多少。
 * @author: wangzibin
 * @create: 2023-02-14
 **/
public class GoldBarSeparation {

    // 小根堆解法
    public static int separation2(int[] arr, int length) {
        int sum = 0;
        if (arr == null) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
        }
        while (queue.size() > 1) {
            int cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 50, 20};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(separation2(arr, 80));
    }

}

