package algorithmic.total.solution.leetcode;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-23
 **/
public class Question39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if (candidates == null || candidates.length < 1 || target == 0) {
            return new ArrayList<>(result);
        }
        process(candidates, target, result, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private static void process(int[] candidates, int target, Set<List<Integer>> result, List<Integer> preUse) {
        if (target == 0) {
            preUse.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            result.add(preUse);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int cur : candidates) {
            List<Integer> use = new ArrayList<>(preUse);
            use.add(cur);
            process(candidates, target - cur, result, use);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}

