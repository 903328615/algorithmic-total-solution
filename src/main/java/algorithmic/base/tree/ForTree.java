package algorithmic.base.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algorithmic-total-solution
 * @description: 树的遍历
 * @author: wangzibin
 * @create: 2023-02-08
 **/
public class ForTree {


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

    public static void prePrint(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        prePrint(head.left);
        prePrint(head.right);
    }

    public static void inPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inPrint(head.left);
        System.out.print(head.val);
        inPrint(head.right);
    }

    public static void postPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        postPrint(head.left);
        postPrint(head.right);
        System.out.print(head.val);
    }

    // 广度优先遍历
    public static void levelPrint(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public static int maxLevelNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode endNode = head;
        TreeNode nextEndNode = null;
        int max = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextEndNode = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextEndNode = node.right;
            }
            count++;
            if (node == endNode) {
                max = Math.max(max, count);
                endNode = nextEndNode;
                count = 0;
            }
        }
        return max;
    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode endNode = root;
        TreeNode nextEndNode = null;
        Integer max = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                nextEndNode = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);

                nextEndNode = node.right;
            }
            if (max == null) {
                max = node.val;
            } else {
                max = Math.max(max, node.val);
            }
            if (node == endNode) {
                result.add(max);
                max = null;
                endNode = nextEndNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n2.right = n5;
        n3.right = n6;
        // 1 2 5 3 4 6
        prePrint(n1);
        System.out.println();
        // 2 5 1 4 3 6
        inPrint(n1);
        System.out.println();
        // 5 2 4 6 3 1
        postPrint(n1);
        System.out.println();
        // 1 2 3 5 4 6
        levelPrint(n1);
        System.out.println();
        System.out.println(maxLevelNum(n1));
    }


}

