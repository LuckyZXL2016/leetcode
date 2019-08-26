package swordOffer.algorithms;

/**
 * 反转链表
 * Created by ZXL on 2019/8/26.
 */
public class a_04_reverseList {
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode node = reverseList(l1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
