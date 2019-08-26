package swordOffer.algorithms;

/**
 * 链表中倒数第k个节点
 * Created by ZXL on 2019/8/26.
 */
class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
    }
}

public class a_03_findKthToTail {
    private static ListNode findKthToTail(ListNode node, int k) {
        ListNode head = node;
        ListNode pre = node;
        int num = k;
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
            k--;
            if (k < 0) {
                pre = pre.next;
            }
        }

        if (num > count) return null;
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

        ListNode res = findKthToTail(l1, 2);
        if (res != null) {
            System.out.println(res.val);
        } else {
            System.out.println("null");
        }
    }
}
