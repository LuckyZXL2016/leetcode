package examination.vivo;

/**
 * 约瑟夫环是一个数学应用题：已知n个人（编号1、2、..n）围坐在一张圆桌周围。从编号为1
 * 的人开始报数，数到m的那个人出列；他的下一个又从1开始报数，数到m的那个人又出列；依
 * 次规律重复下去，直到圆桌周围的人全部出列。请编写一个程序，给定n、m计算出列人员先后顺序。
 * Created by ZXL on 2019/6/4.
 */
class Node {
    int value;
    Node next = null;
}

public class v_01 {
    public static void main(String[] args) {
        int re  = LastRemaining_Solution(5,4);
        System.out.println(re);
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        Node head = new Node();
        head.value = 0;
        head.next = head;
        Node nn = head;
        Node e = head;
        for (int i = 1; i <= n - 1; i++) {
            while (nn.next != head) {
                nn = nn.next;
            }
            Node node = new Node();
            node.value = i;
            nn.next = node;
            node.next = head;
        }
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= m - 2; i++) {
                e = e.next;
            }
            Node d = e.next;
            e.next = d.next;
            e = d.next;
        }
        return e.value;
    }
}
