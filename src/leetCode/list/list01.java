package leetCode.list;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自
 * 的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * Created by ZXL on 2019/3/12.
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class list01 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode q = l1, p = l2, curr = res;
        int carry = 0;
        while (q != null || p != null) {
            int x = (q != null) ? q.val : 0;
            int y = (p != null) ? p.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (q != null)  q = q.next;
            if (p != null)  p = p.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);

        r1.next = r2;
        r2.next = r3;

        ListNode res = addTwoNumbers(l1, r1);
        System.out.println(res.val);
    }
}
