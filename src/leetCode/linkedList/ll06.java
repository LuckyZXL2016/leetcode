package leetCode.linkedList;

/**
 * 在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * Created by ZXL on 2019/7/17.
 *
 * 示例 1:                    示例 2:
 *  输入: 4->2->1->3           输入: -1->5->3->4->0
 *  输出: 1->2->3->4           输出: -1->0->3->4->5
 */
public class ll06 {
    // 归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right  = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;

        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
                h = h.next;
            } else {
                h.next = right;
                right = right.next;
                h = h.next;
            }
        }
        h.next = left != null ? left : right;

        return res.next;
    }
}
