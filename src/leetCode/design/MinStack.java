package leetCode.design;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *  push(x) -- 将元素 x 推入栈中。
 *  pop() -- 删除栈顶的元素。
 *  top() -- 获取栈顶元素。
 *  getMin() -- 检索栈中的最小元素。
 * Created by ZXL on 2019/7/17.
 *
 * 示例:
 *  MinStack minStack = new MinStack();
 *  minStack.push(-2);
 *  minStack.push(0);
 *  minStack.push(-3);
 *  minStack.getMin();   --> 返回 -3.
 *  minStack.pop();
 *  minStack.top();      --> 返回 0.
 *  minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
