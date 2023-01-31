package algorithmic.base.tree;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-01-11
 **/
public class BalanceTree {

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
        public boolean isBalanced;
        public int high;

        public NodeInfo(boolean isBalanced, int high) {
            this.isBalanced = isBalanced;
            this.high = high;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getNodeInfo(root).isBalanced;
    }

    public NodeInfo getNodeInfo(TreeNode node) {
        if (node == null) {
            return new NodeInfo(true, 0);
        }
        // 获取左子树信息
        NodeInfo left = getNodeInfo(node.left);
        // 获取右子树信息
        NodeInfo right = getNodeInfo(node.right);
        // 如果左右子树都平衡且高度差为 1 则我也平衡
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.high - right.high) <= 1;
        // 我的高度为左右子树最大高度 +1
        int high = Math.max(left.high, right.high) + 1;
        return new NodeInfo(isBalanced, high);
    }


}

