package algorithmic.base;

/**
 * @program: algorithmic-total-solution
 * @description: 链表快慢指针问题
 * @author: wangzibin
 * @create: 2022-12-13
 **/
public class ListQuickAndSlowPoint {


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode partition(ListNode head, int num) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lowHead = null;
        ListNode lowEnd = null;
        ListNode equHead = null;
        ListNode equEnd = null;
        ListNode highHead = null;
        ListNode highEnd = null;
        while (head != null) {
            if (head.val < num) {
                if (lowHead == null) {
                    lowHead = head;
                } else {
                    lowEnd.next = head;
                }
                lowEnd = head;
            } else if (head.val == num) {
                if (equHead == null) {
                    equHead = head;
                } else {
                    equEnd.next = head;
                }
                equEnd = head;
            } else {
                if (highHead == null) {
                    highHead = head;
                } else {
                    highEnd.next = head;
                }
                highEnd = head;
            }
            head = head.next;
        }
        if (lowEnd != null) {
            lowEnd.next = equHead;
        }
        if (equEnd != null) {
            equEnd.next = highHead;
        }
        if (highEnd != null) {
            highEnd.next = null;
        }
        if (lowHead != null) {
            return lowHead;
        } else if (equHead != null) {
            return equHead;
        } else {
            return highHead;
        }
    }

    public static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode quick = head.next;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * @Description: 校验回文
     * @Param head  1 -> 2 -> 3 -> 4 -> 5 - null
     * @Return boolean
     */
    public static boolean checkPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = getMid(head);
        ListNode rightPartStart = reverse(mid);
        // 左右对比
        ListNode left = head;
        ListNode right = rightPartStart;
        boolean isPalindrome = true;
        while (left != null && right != null) {
            if (right.val != left.val) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // 复原链表
        reverse(rightPartStart);
        return isPalindrome;
    }

    private static ListNode reverse(ListNode head) {
        ListNode start = head;
        ListNode startPre = null;
        while (start != null) {
            ListNode temp = start.next;
            start.next = startPre;
            startPre = start;
            start = temp;
        }
        return startPre;
    }

    public static void outPrintLink(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(0);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // 0 1 2 3 4 5
        System.out.println(getMid(head).val);
        System.out.println(checkPalindrome(head));
        //outPrintLink(reverse(head));
        outPrintLink(head);
        outPrintLink(partition(head, 2));

/*        Node node = checkPalindrome(head);
        outPrintLink(node);

        outPrintLink(head);*/


        // 0 1 2 3 4 5 6
        ListNode f = new ListNode(6);
        e.next = f;
        System.out.println(getMid(head).val);
        // 0 1 2
        b.next = null;
        System.out.println(getMid(head).val);
        // 0 1 2 3
        b.next = c;
        c.next = null;
        System.out.println(getMid(head).val);
        // 0 1
        a.next = null;
        System.out.println(getMid(head).val);
    }

    // 1 2 3 3 2 1
    // 1 <- 2 <-3  7  3 -> 2 -> 1
    //        pre   slow
    // 1 -> 2 -> 3  <- 3 <- 2 <- 1
    // 1 2 3 6 3 2 1

}

