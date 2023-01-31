package algorithmic.base.tree;

/**
 * @program: algorithmic-total-solution
 * @description: 查找二叉树的后继节点，
 * @author: wangzibin
 * @create: 2023-01-10
 **/
public class FindNextNode {

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.val);
        print(node.right);
    }

    public static TreeNode findNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode result = null;
        // 如果有右孩子，后继节点是右孩子的最左节点
        if (node.right != null) {
            result = node.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
        // 如果没有右孩子,向上找第一个子孩子是左节点的父节点 （有点绕，看代码）
        result = node.parent;
        // 注意最右节点没有后继节点
        while (node.parent != null && node != result.left) {
            node = node.parent;
            result = node.parent;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        head.left = node1;
        node1.parent = head;

        head.right = node3;
        node3.parent = head;

        node3.right = node4;
        node4.parent = node3;

        node4.left = node5;
        node5.parent = node4;

        node4.right = node6;
        node6.parent = node4;

        node5.right = node7;
        node7.parent = node5;

        node7.right = node8;
        node8.parent = node7;


        print(head);

        System.out.println();
        System.out.println(findNextNode(node1));
        System.out.println(findNextNode(head));
        System.out.println(findNextNode(node3));
        System.out.println(findNextNode(node5));
        System.out.println(findNextNode(node7));
        System.out.println(findNextNode(node8));
        System.out.println(findNextNode(node4));
        System.out.println(findNextNode(node6));
    }

}

