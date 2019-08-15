package examination.pufa;

import java.util.Scanner;

/**
 * 1加2/3加3/5加4/7.......输出结果
 * Created by ZXL on 2019/8/15.
 */
public class p_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double res = getValue(n);
        System.out.println(res);
    }

    private static double getValue(int n) {
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            res += i / (2.0 * i - 1.0);
        }
        return res;
    }
}
