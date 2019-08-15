package examination.pufa;

import java.util.Scanner;

/**
 * 输入几个单词，将字母变换成另外一组单词输出？
 * Created by ZXL on 2019/8/15.
 *
 * 如果字母是i，则变换后的字母是26+i-1
 */
public class p_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char)('z' - (chars[i] - 'a'));
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)('Z' - (chars[i] - 'A'));
            }
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
