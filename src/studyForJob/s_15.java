package studyForJob;

/**
 * list链表重排序
 * l0 -> l1 -> l2 -> ... -> ln
 * ==>
 * l0 -> ln -> l1 -> ln-1 -> ...
 * Created by ZXL on 2019/8/29.
 */
class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
    }
}

public class s_15 {
    private static ListNode reOrder(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode low = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        ListNode preNode = low.next;
        low.next = null;

        ListNode revNode = reverseNode(preNode);

        ListNode cur = head;
        while (cur != null && revNode != null) {
            ListNode tmpNode1 = cur.next;
            ListNode tmpNode2 = revNode.next;
            cur.next = revNode;
            revNode.next = tmpNode1;
            revNode = tmpNode2;
            cur = tmpNode1;
        }

        return head;
    }

    private static ListNode reverseNode(ListNode node) {
        ListNode pre = null;
        ListNode next = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
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

        ListNode res = reOrder(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
