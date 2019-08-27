package swordOffer.algorithms;

/**
 * 合并两个有序链表
 * Created by ZXL on 2019/8/26.
 */
public class a_05_mergeList {
    private static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }

    private static ListNode mergeList2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode mergeHead = null;
        ListNode current = null;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (mergeHead == null) {
                    mergeHead = current = l1;
                } else {
                    current.next = l1;
                    current = l1;
                }
                l1 = l1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = l2;
                } else {
                    current.next = l2;
                    current = l2;
                }
                l2 = l2.next;
            }
        }
        return mergeHead;
    }
}
