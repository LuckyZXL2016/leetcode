package leetCode.linkedList;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * Created by ZXL on 2019/7/9.
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class ll03 {

    // 方法一
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode old_tail = head;
        int m;
        for (m = 1; old_tail.next != null; m++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        ListNode new_tail = head;
        for (int i = 0; i < m - k % m - 1; i++) {
            new_tail = new_tail.next;
        }

        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }

    // 方法二
    public static ListNode rotateRight2(ListNode head, int k) {

        if (head == null) return null;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] nums = new int[len];
        int i = 0;
        while (head != null) {
            nums[i] = head.val;
            head = head.next;
            i++;
        }

        nums = moveArrayElement(nums, k);

        head = new ListNode(nums[0]);
        ListNode q = head;
        for (int j = 1; j < nums.length; j++) {
            q.next = new ListNode(nums[j]);
            q = q.next;
        }
        return head;
    }

    public static int[] moveArrayElement(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        int newk = k % len;

        for (int i = 0; i < len; i++) {
            newNums[(i + k) % len] = nums[i];
        }
        return newNums;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = null;

        rotateRight2(head, 2);
    }
}
