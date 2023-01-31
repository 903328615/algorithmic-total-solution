package algorithmic.base.tree;

import javax.xml.soap.Node;

/**
 * @program: algorithmic-total-solution
 * @description: 二叉搜索子树最大键和值  https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/
 * @author: wangzibin
 * @create: 2023-01-11
 **/
public class MaxSumBST {

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

    public static class NodeInfo {
        // 当前节点子树最大值
        private int max;
        private int min;
        private boolean isBst;
        private int bstSum;
        private int bstMaxSum;

        @Override
        public String toString() {
            return "NodeInfo{" +
                    "max=" + max +
                    ", min=" + min +
                    ", isBst=" + isBst +
                    ", bstSum=" + bstSum +
                    ", bstMaxSum=" + bstMaxSum +
                    '}';
        }
    }

    public static NodeInfo getInfo(TreeNode node) {
        if (node == null) {
            NodeInfo empty = new NodeInfo();
            empty.isBst = true;
            empty.min = Integer.MAX_VALUE;
            empty.max = Integer.MIN_VALUE;
            return empty;
        }
        NodeInfo leftInfo = getInfo(node.left);
        NodeInfo rightInfo = getInfo(node.right);
        NodeInfo current = new NodeInfo();
        current.max = max(node.val, leftInfo.max, rightInfo.max);
        current.min = min(node.val, leftInfo.min, rightInfo.min);
        // 判断是否与我有关, 当且仅当我也是二叉搜索树时最大值才与我有关，否则只需要比较子树值即可
        if (leftInfo.isBst && rightInfo.isBst && leftInfo.max < node.val && rightInfo.min > node.val) {
            // 左右子树都是搜索树，且 左子树最大值 小于 当前节点值 ，右子树最小值 大于 当前节点值，则可讨论与当前节点有关的情况
            current.isBst = true;
            current.bstSum = node.val + leftInfo.bstSum + rightInfo.bstSum;
            current.bstMaxSum = max(current.bstSum, leftInfo.bstMaxSum, rightInfo.bstMaxSum);
        } else {
            current.isBst = false;
            current.bstMaxSum = Math.max(leftInfo.bstMaxSum, rightInfo.bstMaxSum);
        }

        return current;
    }

    public static int max(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    public static int min(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }


    public static int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int bstMaxSum = getInfo(root).bstMaxSum;
        return Math.max(bstMaxSum, 0);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = null;
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(-5);
        TreeNode treeNode20 = new TreeNode(20);
        treeNode1.right = treeNode10;
        treeNode10.left = treeNode5;
        treeNode10.right = treeNode20;
        System.out.println(maxSumBST(treeNode1));

    }

}

