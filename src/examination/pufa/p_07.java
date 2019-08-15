package examination.pufa;

import java.util.Scanner;

/**
 * N的阶乘
 * Created by ZXL on 2019/8/15.
 */
public class p_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        System.out.println(num);
    }
}
