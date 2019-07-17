package leetCode.linkedList;

/**
 * 反转一个单链表。
 * Created by ZXL on 2019/7/17.
 *
 * 示例:
 *  输入: 1->2->3->4->5->NULL
 *  输出: 5->4->3->2->1->NULL
 */
public class ll08 {
    // 方法一：头插法
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode p;
        while (head != null) {
            p = head;
            head = head.next;
            p.next = newHead.next;
            newHead.next = p;
        }
        return newHead.next;
    }

    // 方法二：
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(reverseList(l1));
    }
}
