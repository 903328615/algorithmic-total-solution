package algorithmic.base.tree;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-08
 **/
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeSerialization {
    // 序列化二叉树
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // 反序列化二叉树
    public static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        String val = nodes.removeFirst();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
        String serialize = serialize(n1);
        System.out.println(serialize);
        // 1 2 5 3 4 6
        prePrint(deserialize(serialize));
    }
}



