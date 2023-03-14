package algorithmic.total.solution.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author: wangzibin
 * @create: 2023-03-09
 **/
public class Question143 {

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

    public static void reorderList2(ListNode head) {
        // 找中点 + 翻转链表 + 拼接
        // 1 2 3 4 5 6 7
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = head.next; // 4
        ListNode fast = head.next.next; // 7
        if (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // 翻转链表
        // 1 2 3 4 5 6 7
        // 4 5
        // 5 6
        // 7
        ListNode pre = null;
        ListNode cur = mid.next;
        mid.next=null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode fNext;
        ListNode sNext;
        cur = pre;
        while (head != null && cur != null) {
            fNext = head.next;
            sNext = cur.next;
            head.next = cur;
            cur.next = fNext;
            head = fNext;
            cur = sNext;
        }

    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        ListNode node = head;
        while (node != null) {
            map.put(count++, node);
            node = node.next;
        }
        int i = 0;
        int j = count - 1;
        while (i < j) {
            map.get(i).next = map.get(j);
            i++;
            if (i == j) {
                break;
            }
            map.get(j).next = map.get(i);
            j--;

        }
        map.get(i).next = null;
    }


}

