package examination.tencent;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * Created by ZXL on 2019/6/10.
 */
public class t_13 {
    // 2的31次方 - 1为2147483647； 2的-31次方为 -2147483647
    public static int reverse(int x) {
        int m = 0, res = 0;
        while (x != 0) {
            m = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && m > 7)) {
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && m < -8)) {
                return 0;
            }
            res = res * 10 + m;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
