package studyForJob;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈溢出，堆溢出
 * Created by ZXL on 2020/3/30.
 */
public class test3 {
    public static void main(String[] args) {
//        stack s1 = new stack();
//        s1.test();

        List<test3> heap = new ArrayList<>();
        while (true) {
            heap.add(new test3());
        }
    }
}

// 栈溢出
class stack {
    public void test() {
        test();
    }
}
