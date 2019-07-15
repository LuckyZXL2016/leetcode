package leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。说明：不允许修改给定的链表。
 * Created by ZXL on 2019/7/15.
 * <p>
 * 示例 ：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
// 参考 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
public class ll05 {

    // 方法一 hash操作
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

    // 方法二 快慢指针
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;

        // 找出相遇的结点
        ListNode intersectNode = getIntersect(head);
        if (intersectNode == null) {
            return null;
        } else {
            // 利用相遇结点
            ListNode ptr1 = head;
            ListNode ptr2 = intersectNode;
            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }
    }

    // 找出快慢指针相遇的结点
    public ListNode getIntersect(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;

            if (low == fast) {
                return fast;
            }
        }
        return null;
    }
}
