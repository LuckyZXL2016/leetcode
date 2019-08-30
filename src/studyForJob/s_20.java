package studyForJob;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * Created by ZXL on 2019/8/30.
 */
public class s_20 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    private int size() {
        return q1.size() + q2.size();
    }

    // 队列数据转到另一队列
    private void putN_1ToAnother() {
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
        } else {
            while (q2.size() > 1) {
                q1.add(q2.poll());
            }
        }
    }

    // 入栈
    public void push(Integer x) {
        q1.add(x);
    }

    // 出栈
    public int pop() {
        if (size() != 0) {
            if (!q1.isEmpty()) {
                putN_1ToAnother();
                return q1.poll();
            } else {
                putN_1ToAnother();
                return q2.poll();
            }
        } else {
            System.out.println("Exception");
            return -1;
        }
    }
}
