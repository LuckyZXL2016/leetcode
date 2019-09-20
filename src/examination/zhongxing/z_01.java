package examination.zhongxing;

/**
 * 中兴现场面试题
 * Created by ZXL on 2019/9/20.
 */
public class z_01 {
    private static void test1() {
        String a = "1";
        String b = "1";
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    private static void doSomething(int count) {
        doSomething(++count);
    }

    public static void main(String[] args) {
        // 都相等
        test1();

        // 会溢出
        doSomething(1);
    }
}
