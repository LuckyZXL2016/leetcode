package leetCode.linkedList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * Created by ZXL on 2019/6/12.
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ll01 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode l3 = new ListNode(0);
        ListNode r = l3;
        ListNode p = l1, q = l2;
        while (p != null || q != null) {
            if (p == null) {
                r.next = new ListNode(q.val);
                q = q.next;
                r = r.next;
            } else if (q == null) {
                r.next = new ListNode(p.val);
                p = p.next;
                r = r.next;
            } else {
                if (p.val <= q.val) {
                    r.next = new ListNode(p.val);
                    p = p.next;
                    r = r.next;
                } else {
                    r.next = new ListNode(q.val);
                    q = q.next;
                    r = r.next;
                }
            }
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
    }
}
