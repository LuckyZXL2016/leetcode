package leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表
 * 中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * Created by ZXL on 2019/7/15.
 * <p>
 * 示例 ：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class ll04 {

    // 第一种方法
    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode low = head;
        ListNode fast = head.next;

        while (low != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 第二种方法
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();
        while (head != null) {
            if (nodeSeen.contains(head)) {
                return true;
            } else {
                nodeSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
