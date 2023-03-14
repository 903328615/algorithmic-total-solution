package algorithmic.total.solution.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-14
 **/
public class Offer34 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 经典的二叉树递归问题
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 叶子节点
        if (root.right == null && root.left == null) {
            if (root.val == target) {
                LinkedList<Integer> item = new LinkedList<>();
                item.add(root.val);
                result.add(item);
            }
        }
        List<List<Integer>> right = pathSum(root.right, target - root.val);
        List<List<Integer>> left = pathSum(root.left, target - root.val);
        for (List<Integer> item : right) {
            List<Integer> newItem = new LinkedList<>(item);
            newItem.add(0, root.val);
            result.add(newItem);
        }
        for (List<Integer> item : left) {
            List<Integer> newItem = new LinkedList<>(item);
            newItem.add(0, root.val);
            result.add(newItem);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

