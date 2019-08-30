package studyForJob;

/**
 * 单向链表每 k个元素倒序
 * Created by ZXL on 2019/8/30.
 */
public class s_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;

            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }

            cur = next;
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null) return null;
        ListNode head = pre.next;
        ListNode cur = pre.next.next;

        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode node = reverseKGroup(l1, 3);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
