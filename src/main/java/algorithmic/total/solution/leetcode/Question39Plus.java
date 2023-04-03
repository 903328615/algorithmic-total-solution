package algorithmic.total.solution.leetcode;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-23
 **/
public class Question39Plus {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length < 1 || target == 0) {
            return new ArrayList<>(result);
        }
        Arrays.sort(candidates);
        process(candidates, 0, target, result, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private static void process(int[] candidates, int index, int target, List<List<Integer>> result,
            List<Integer> preUse) {
        if (target == 0) {
            result.add(preUse);
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        int useNum = 0;
        if (candidates[index] > target) {
            // 排序过后可以进行剪枝，如果当前数已经大于目标值，则后续无解
            return;
        }
        while (useNum * candidates[index] <= target) {
            List<Integer> use = new ArrayList<>(preUse);
            for (int i = 0; i < useNum; i++) {
                use.add(candidates[index]);
            }
            process(candidates, index + 1, target - useNum * candidates[index], result, use);
            useNum++;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

