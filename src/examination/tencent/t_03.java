package examination.tencent;

import java.util.Scanner;

/**
 * 判断数字的回文，不能转成字符串
 * Created by ZXL on 2019/3/22.
 */
public class t_03 {
    public boolean isPalindrome(int n) {
        int s, j = 0;
        int res = 0;
        s = n;
        while (s != 0) {
            res = res * 10 + s % 10;
            s = s / 10;
        }
        if (n == res) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        t_03 example = new t_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(example.isPalindrome(n));
    }
}
