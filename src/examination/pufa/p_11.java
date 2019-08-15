package examination.pufa;

import java.util.Scanner;

/**
 * 凯撒加密解密,就是给你由大写字母组成的字符串,求出原来的字符串,加密。
 * 方式很简单就是字符串后移五位,比如原来是A加密后是F,其余数字等标点符号原样输出。
 * Created by ZXL on 2019/8/15.
 */
public class p_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String newStr = kaisaCode(str);
        System.out.println(newStr);
    }

    private static String kaisaCode(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                newStr += (char)((ch - 'a' + 5) % 26 + 'a');
            }
            if (ch >= 'A' && ch <= 'Z') {
                newStr += (char)((ch - 'A' + 5) % 26 + 'A');
            }
        }
        return newStr;
    }
}
