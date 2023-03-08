package algorithmic.total.solution.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithmic-total-solution
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author: wangzibin
 * @create: 2023-03-08
 **/
public class Question78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        processEnd(nums, 0, result, new ArrayList());
        return result;
    }

    private static void processEnd(int[] nums, int start, List<List<Integer>> result, List<Integer> item) {

        if (start == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        // 没我的情况
        processEnd(nums, start + 1, result, item);
        item.add(nums[start]);
        processEnd(nums, start + 1, result, item);
        item.remove(item.size() - 1);

    }


    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}

