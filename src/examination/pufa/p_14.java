package examination.pufa;

import java.util.Scanner;

/**
 * 给你两个数，例如23和456，23 * 456=2 * 4 2 * 5 2 * 6 3 * 4 3 * 5 3 * 6，让你实现这个算法。
 * 累积乘积和
 * Created by ZXL on 2019/8/15.
 */
public class p_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        String res = accumulate(str1, str2);
        System.out.println(res);
    }

    private static String accumulate(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int len = chars1.length + chars2.length;
        char[] res = new char[len];

        for (int i = chars1.length - 1; i >= 0; i--) {
            int tmp = 0;
            int index = len - 1;
            for (int j = chars2.length - 1; j >= 0; j--) {
                int sum = (chars2[j] - '0') * (chars1[i] - '0') + res[index] + tmp;
                tmp = sum / 10;
                res[index--] = (char)(sum % 10);
            }
            res[index] = (char)tmp;
            len--;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] += '0';
        }
        String strRes = new String(res);
        if (res[0] == '0') {
            return strRes.substring(1);
        } else {
            return strRes;
        }
    }
}
