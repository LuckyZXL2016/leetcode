package examination.pufa;

import java.util.Scanner;

/**
 * 判断一个数是不是素数
 * Created by ZXL on 2019/8/15.
 */
public class p_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        boolean flag = isPrime(num);
        System.out.println(flag);
    }

    private static boolean isPrime(int num) {
        if (num <= 2) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return true;
        }
        return false;
    }
}
