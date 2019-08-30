package studyForJob;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU设计
 * 双链表 + HashMap
 * Created by ZXL on 2019/8/30.
 */
class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
}
public class s_23 {
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public s_23(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    // 加入到头结点
    private void addNode(DLinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void deleteNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        deleteNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        deleteNode(node);
        return node;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key,node);
            addNode(node);
            size++;
            if (size > capacity) {
                DLinkedNode newNode = popTail();
                cache.remove(newNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
