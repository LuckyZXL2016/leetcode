package examination.tencent;

/**
 * 问题描述：给定两个单链表，它们分别表示一个非负的整数，每个节点存储一个
 * 数字，将两个单链表代表的整数相加，并返回结果单链表。
 * Created by ZXL on 2019/3/21.
 * <p>
 * Input:(2->4->3)+(5->6->4)
 * Output:7->0->8
 * <p>
 * Input:(3->2->9)+(8->7)
 * Output:1->0->0->1
 */
public class t_01 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getSum(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode q = l1, p = l2, curr = res;
        int balance = 0;
        int x, y, sum;
        while (q != null || p != null) {
            x = q == null ? 0 : q.val;
            y = p == null ? 0 : p.val;
            sum = x + y + balance;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            balance = sum / 10;
            if (q.next != null) q = q.next;
            if (p.next != null) p = p.next;
        }
        if (balance == 1) {
            curr.next = new ListNode(1);
        }
        return res.next;
    }
}
