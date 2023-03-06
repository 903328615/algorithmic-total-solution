package algorithmic;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 钱数组合问题
 * 给定纸币面值数组 [5,33,52,100,89] 给定目标钱数 1000
 * 可以使用任意面值纸币任意张，问有多少种组合方法
 * 假定数组值不重复，且都大于 0
 * @author: wangzibin
 * @create: 2023-03-03
 **/
public class MoneyGroupQuestion {


    public static int solution(int[] arr, int target) {
        // 假定一个暴力递归的尝试方法
        Map<String, Integer> cache = new HashMap<>();
        return process(arr, target, 0, 0, cache);
    }

    /**
     * @param arr
     * @param target
     * @param already 已凑够钱数
     * @param index   当前要抉择用的面值下标
     * @param cache
     * @return int 返回有多少种方法
     * @description:
     */
    public static int process(int[] arr, int target, int already, int index,
            Map<String, Integer> cache) {
        String key = already + "" + index;
        Integer result = cache.get(key);
        if (result != null) {
            return result;
        }
        if (already == target) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        int num = 0;
        int cur = arr[index];
        // 与当前有关, 那与当前的选择多有关呢？从 0 个开始选 暴力走每个选择流程
        int count = 0;
        while ((already + cur * count) <= target) {
            int alreadyNext = already + cur * count;
            num += process(arr, target, alreadyNext, index + 1, cache);
            count++;
        }
        cache.put(key, num);
        return num;
    }

    public static int solution2(int[] arr, int target) {
        // 假定一个暴力递归的尝试方法
        return process2(arr, target);
    }

    // log(n*target)
    public static int process2(int[] arr, int target) {
        int high = arr.length; // 使用当前的面值 有多少种到达
        int width = target + 1; // 已经使用的面值
        int[][] dp = new int[high][width];
        for (int i = 0; i < high; i++) {
            dp[i][target] = 1;
        }
        for (int j = 0; j < width - 1; j++) {
            int need = target - j;
            dp[high - 1][j] = need % arr[high - 1] == 0 ? 1 : 0;
        }
        for (int i = high - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                int num = 0;
                int cur = arr[i];
       /*         // 与当前无关
                num += dp[i + 1][j];
                // 与当前有关, 那与当前的选择多有关呢？暴力走每个选择流程

                int count = 1;
                while ((j + cur * count) <= target) {
                    num += dp[i + 1][j + cur * count];
                    count++;
                }*/
                // 枚举行为优化，关系优化
                num = dp[i + 1][j] + ((j + cur) > target ? 0 : dp[i][j + cur]);
                dp[i][j] = num;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 10, 50, 100}, 1000));
        System.out.println(solution2(new int[]{5, 10, 50, 100}, 1000));
    }

}

