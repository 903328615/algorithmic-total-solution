package algorithmic.base.model;

import algorithmic.base.tree.ForTree;

import java.util.Random;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-07-19
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void printTree(TreeNode root) {
        System.out.println(convertToParenthesisNotation(root));
    }

    private static String convertToParenthesisNotation(TreeNode node) {
        if (node == null) {
            return "null";
        }

        String left = convertToParenthesisNotation(node.left);
        String right = convertToParenthesisNotation(node.right);

        return node.val + "(" + left + ", " + right + ")";
    }

    public static TreeNode generateRandomTree(int depth, int minValue, int maxValue) {
        if (depth <= 0 || Math.random() < 0.1) {
            return null;
        }

        Random random = new Random();
        int value = random.nextInt(maxValue - minValue + 1) + minValue;
        TreeNode root = new TreeNode(value);

        root.left = generateRandomTree(depth - 1, minValue, maxValue);
        root.right = generateRandomTree(depth - 1, minValue, maxValue);

        return root;
    }

    public static TreeNode generateStaticTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateRandomTree(4, 1, 100);
        printTree(root);
        printTree(generateStaticTree());
    }
}

