package algorithmic.total.solution.leetcode.offer;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-14
 **/
public class offer22 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        if (k > length) {
            return null;
        }
        int f = length - k;
        cur = head;
        for (int i = 0; i < f; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

