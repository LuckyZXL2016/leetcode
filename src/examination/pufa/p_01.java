package examination.pufa;

import java.util.Scanner;

/**
 * 找出正整数中偶数，并输出相加后的数
 * Created by ZXL on 2019/8/15.
 *
 * 例：输入 5548 输出 12
 */
public class p_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long res = 0;
        while (num != 0) {
            long tmp = num % 10;
            num /= 10;
            if (tmp % 2 == 0) {
                res += tmp;
            }
        }
        System.out.println(res);
    }
}
