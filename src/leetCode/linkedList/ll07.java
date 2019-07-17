package leetCode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * Created by ZXL on 2019/7/17.
 *
 * 示例 :
 *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *  输出：Reference of the node with value = 8
 */
public class ll07 {

    // 方法一：暴力法
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            while (pB != null) {
                if (pB == pA) {
                    return pB;
                } else {
                    pB = pB.next;
                }
            }
            pB = headB;
            pA = pA.next;
        }
        return null;
    }

    // 方法二：哈希表法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Map<ListNode, Integer> map = new HashMap<>();
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            map.put(pA, 1);
            pA = pA.next;
        }
        while (pB != null) {
            if (map.containsKey(pB)){
                return pB;
            } else {
                map.put(pB, 1);
                pB = pB.next;
            }
        }
        return null;
    }

    // 方法三：双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
