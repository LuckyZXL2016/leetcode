package examination.pufa;

import java.util.Scanner;

/**
 * 字符串反转
 * Created by ZXL on 2019/8/15.
 */
public class p_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();

        char[] chars = str.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = tmp;
        }

        String newStr = new String(chars);
        System.out.println(newStr);
    }
}
