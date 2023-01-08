package algorithmic.base;

// 随机链表复制
public class RandomListCopy {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copy(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode temp = head;
        // 首先沿着 next 将每个节点复制，并挂载在原节点的下一个
        while (temp != null) {
            ListNode next = temp.next;
            ListNode copyNode = new ListNode(temp.val);
            copyNode.next = next;
            temp.next = copyNode;
            temp = next;
        }
        // 调整复制节点的 random 指向
        temp = head;
        while (temp != null) {
            ListNode next = temp.next.next;
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = next;
        }
        // 拆分链表
        temp = head;
        ListNode copyHeadTemp = head.next;
        ListNode copyHead = head.next;
        while (copyHeadTemp != null) {
            ListNode next = copyHeadTemp.next;
            if (next == null) {
                temp.next = null;
                break;
            }
            ListNode copyNext = next.next;
            temp.next = next;
            copyHeadTemp.next = copyNext;
            temp = next;
            copyHeadTemp = copyNext;
        }

        return copyHead;
    }

    public static void outPrintLink(ListNode listNode) {
        while (listNode != null) {
            System.out.print(" c:" + listNode.val);
            if (listNode.random != null)
                System.out.print(" r:" + listNode.random.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        a.random = b;
        b.random = c;
        b.next = c;
        c.random = a;
        ListNode copy = copy(a);
        outPrintLink(a);
        outPrintLink(copy);
    }

}
