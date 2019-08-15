package examination.pufa;

import java.util.Scanner;

/**
 * 把字符串中的字符a和A换成c输出
 * Created by ZXL on 2019/8/15.
 */
public class p_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'A') {
                chars[i] = 'c';
            }
        }

        for (char c: chars) {
            System.out.print(c);
        }
    }
}
