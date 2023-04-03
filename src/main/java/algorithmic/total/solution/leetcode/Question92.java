package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description:给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @author: wangzibin
 * @create: 2023-03-21
 **/
public class Question92 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode totalHeadEnd = null;
        ListNode totalTailStart = null;
        ListNode cur = head;
        int curNum = 1;
        while (curNum != left) {
            totalHeadEnd = cur;
            cur = cur.next;
            curNum++;
        }
        // 找到翻转起点,一直翻转到终点
        ListNode partHead = null;
        ListNode next = null;
        ListNode partTail = cur;
        // 等于的时候，操作的是最后一个节点的翻转
        while (curNum <= right) {
            next = cur.next;
            cur.next = partHead;
            partHead = cur;
            cur = next;
            curNum++;
        }
        totalTailStart = next;
        // 穿针引线阶段， 翻转部分 分隔头部-> (反转部分头部 -> 反转部分尾部) -> 分隔尾部
        partTail.next = totalTailStart;
        if (totalHeadEnd != null) {
            totalHeadEnd.next = partHead;
            return head;
        }
        return partHead;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode cur = reverseBetween(a, 1, 4);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

