package leetCode.linkedList;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * Created by ZXL on 2019/6/12.
 * <p>
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 复杂度分析
 *  时间复杂度： O(N logk) ，其中 k 是链表的数目。
 *      我们可以在 O(n) 的时间内合并两个有序链表，其中 n 是两个链表中的总节点数。
 *  空间复杂度：O(1)O(1)
 *      我们可以用 O(1)O(1) 的空间实现两个有序链表的合并。
 */
public class ll02 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        return solve(lists, 0, len - 1);
    }

    private ListNode solve(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = solve(lists, start, mid);
        ListNode right = solve(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else if (node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
