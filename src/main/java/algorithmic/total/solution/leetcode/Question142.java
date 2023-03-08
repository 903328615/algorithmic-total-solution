package algorithmic.total.solution.leetcode;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-03-07
 **/
public class Question142 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 追击有环
            if (slow == fast) {
                break;
            }
        }
        // 找入环点
        if (slow == fast) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n3.next=n2;
        n2.next=n0;
        n0.next=n4;
        n4.next=n2;
        ListNode n1 = new ListNode(1);
        System.out.println(detectCycle(n1));
    }
}

