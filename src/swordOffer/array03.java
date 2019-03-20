package swordOffer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * Created by ZXL on 2019/3/4.
 */
public class array03 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    public static void main(String args[]) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = null;
        ArrayList<Integer> result = printListFromTailToHead(ln1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
