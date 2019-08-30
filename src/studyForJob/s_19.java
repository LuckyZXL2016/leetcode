package studyForJob;

import java.util.Stack;

/**
 * 两个栈实现队列
 * Created by ZXL on 2019/8/30.
 */
public class s_19 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    private int size() {
        return s1.size() + s2.size();
    }

    // 栈 s1 数据复制到 s2
    private void s1ToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    // 入队
    public void add(Integer x) {
        s1.push(x);
    }

    // 出队
    public int pop() {
        if (size() != 0) {
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                s1ToS2();
                return s2.pop();
            }
        } else {
            System.out.println("队列为空，出队出错");
            return -1;
        }
    }
}
