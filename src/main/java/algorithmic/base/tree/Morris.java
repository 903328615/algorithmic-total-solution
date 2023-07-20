package algorithmic.base.tree;

import algorithmic.base.model.TreeNode;

/**
 * @program: algorithmic-total-solution
 * @description: Morris 遍历二叉树，一个非递归的算法 空间时间都为 O(N)
 * cur 节点开始指向整个树的 root 根节点 cur 为 null 时结束循环
 * 判断 cur 节点是否有左树 如果没有左树 cur = cur.right
 * 如果有左树，找到左孩子的最右节点
 * 1. 如果最右节点 mostRight.right == null then mostRight.right = cur and cur = cur.left 往左走
 * 2. 如果最右节点 mostRight.right != null and mostRight.right == cur
 * 不为空则一定是这种情况，该情况为情况 1 命中后生成 mostRight.right = null and cur = cur.right 往右走
 * 那对于 Morris 序列即 cur 所走过的路，根据上述规则，对于有左孩子的节点 cur 会走过两次，而无左孩子的节点则只走过一次。
 * 根据此特性，我们控制打印遇到的打印时机，即可实现先序和中序遍历
 * @author: wangzibin
 * @create: 2023-07-19
 **/
public class Morris {


    /**
     * 1
     * 2   3
     * 4 5 6 7
     * <p>
     * morris 序为  1 2 4 2
     */

    public static int morrisPrint(TreeNode root) {
        TreeNode cur = root;
        // 从 0 开始，走下一步才更新自己
        int level = 0;
        int minLevel = Integer.MAX_VALUE;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mostRight = cur.left;
                // 找到左节点最右节点
                int mostRightLevel = 1;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                    mostRightLevel++;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    // 第一次到自己 这个时候打印则为先序遍历
                    System.out.print(cur.val + " ");
                    level++;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次回到自己
                    //System.out.print(cur.val + " ");
                    // 最右节点做孩子也为 null则为叶节点
                    if (mostRight.left == null) {
                        minLevel = Math.min(level, minLevel);
                    }
                    level = level - mostRightLevel;
                    mostRight.right = null;

                }
            } else {
                // 仅一次节点
                System.out.print(cur.val + " ");
                level++;
            }
            //System.out.print(cur.val + " ");
            cur = cur.right;

        }
        System.out.println();
        return level;
    }

    public static void main(String[] args) {
        System.out.println(morrisPrint(TreeNode.generateStaticTree()));
    }

}

