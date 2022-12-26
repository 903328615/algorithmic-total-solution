package algorithmic.base;

/**
 * @program: algorithmic-total-solution
 * @description: 链表快慢指针问题
 * @author: wangzibin
 * @create: 2022-12-13
 **/
public class ListQuickAndSlowPoint {


    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node slow = head.next;
        Node quick = head.next.next;

        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        if (quick.next != null) {
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // 0 1 2 3 4 5
        System.out.println(getMid(head).value);
        // 0 1 2 3 4 5 6
        Node f = new Node(6);
        e.next = f;
        System.out.println(getMid(head).value);
        // 0 1 2
        b.next = null;
        System.out.println(getMid(head).value);
        // 0 1 2 3
        b.next = c;
        c.next = null;
        System.out.println(getMid(head).value);
        // 0 1
        a.next = null;
        System.out.println(getMid(head).value);
    }

    // 1 2 3 3 2 1
    // 1 <- 2 <-3   3 -> 2 -> 1
    //        pre   slow
    // 1 2 3 6 3 2 1

}

