package algorithmic.base;

// 两个链表相交问题
public class TwoListCross {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    // 给定两个链表头节点，判断是否相交，如果相交返回第一个相交节点，否则返回 null
    public static ListNode isCross(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode ring1 = haveRing(head1);
        ListNode ring2 = haveRing(head2);
        // 两个无环链表相交问题
        if (ring1 == null && ring2 == null) {
            ListNode temp1 = head1;
            ListNode temp2 = head2;
            int count1 = 1;
            int count2 = 1;
            // 取两个链表最后一个节点，并计数
            while (temp1.next != null) {
                count1++;
                temp1 = temp1.next;
            }
            while (temp2.next != null) {
                count2++;
                temp2 = temp2.next;
            }
            // 尾节点不同说明不相交
            if (temp1 != temp2) {
                return null;
            }
            ListNode longList = count1 > count2 ? head1 : head2;
            ListNode shortList = count1 > count2 ? head2 : head1;
            int needFirstGo = Math.abs(count1 - count2);
            // 因为相交最后一定共用，长链表先走，差值步，然后一起走，首次相遇点返回即可
            for (int i = 0; i < needFirstGo; i++) {
                longList = longList.next;
            }
            while (longList != shortList) {
                longList = longList.next;
                shortList = shortList.next;
            }
            return longList;

        } else if (ring1 != null && ring2 != null) {
            if (ring1 == ring2) {
                return ring1;
            } else {
                ListNode temp = ring1.next;
                while (temp != ring1) {
                    if (temp == ring2) {
                        // 如果是有环相交，两个链表入环点不同则返回任意一个都可以
                        return ring2;
                    }
                    temp = temp.next;
                }
                // ring1 走了一圈都没有遇到 ring2 说明两个有环链表不相交
                return null;
            }
        } else {
            return null;
        }
    }

    private static ListNode haveRing(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            // 若有环，相交必追上
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
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
        e.next = null;

        ListNode a2 = new ListNode(10);
        ListNode b2 = new ListNode(20);
        ListNode c2 = new ListNode(30);
        ListNode d2 = new ListNode(40);
        ListNode e2 = new ListNode(50);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = null;
        // 无环无相交
        System.out.println(isCross(a, a2));
        // 无环有相交
        c.next = d2;
        System.out.println(isCross(a, a2));
        // 有环有无相交
        c.next = b;
        System.out.println(isCross(a, a2));
        // 有环有无相交2
        c2.next = b2;
        System.out.println(isCross(a, a2));
        // 有环同节点相交
        c2.next = b;
        System.out.println(isCross(a, a2));
        // 有环不同节点相交
        c.next = d;
        e.next = b;
        c2.next = c;
        System.out.println(isCross(a, a2));
    }

}
