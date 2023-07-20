package algorithmic.total.solution.leetcode;

import algorithmic.total.solution.leetcode.model.ListNode;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-07-03
 **/
public class Question445 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }
        ListNode cur1 = revert(l1);
        ListNode cur2 = revert(l2);
        ListNode result = null;
        ListNode resultHead = null;
        int addNum = 0;
        while (cur1 != null && cur2 != null) {
            int total = cur1.val + cur2.val + addNum;
            addNum = total/10;
            int curNum = total % 10;
            ListNode node = new ListNode(curNum);
            if (result == null) {
                result = node;
                resultHead = result;
            } else {
                result.next = node;
                result = result.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int total = cur1.val + addNum;
            addNum = total/10;
            int curNum = total % 10;
            result.next = new ListNode(curNum);
            result = result.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int total = cur2.val + addNum;
            addNum = total/10;
            int curNum = total % 10;
            result.next = new ListNode(curNum);
            result = result.next;
            cur2 = cur2.next;
        }
        if (addNum > 0) {
            result.next = new ListNode(addNum);
        }
        return revert(resultHead);
    }

    private static ListNode revert(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode next2 = new ListNode(2);
//        ListNode next4 = new ListNode(4);
//        ListNode next3 = new ListNode(3);
//        l1.next = next2;
//        next2.next = next4;
//        next4.next = next3;

        ListNode l2 = new ListNode(9);
        ListNode next6 = new ListNode(9);
        ListNode next42 = new ListNode(4);
        l2.next = next6;
        //next6.next = next42;

        addTwoNumbers(l1, l2);
        System.out.println(1/10);
    }
}

