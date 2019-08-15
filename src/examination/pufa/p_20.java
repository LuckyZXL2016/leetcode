package examination.pufa;

import java.util.Scanner;

/**
 * 输入abc d 输出abc d，就是去掉一个字符串最后的空格
 * Created by ZXL on 2019/8/15.
 */
public class p_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int len = str.length();
        int i = len - 1;
        for (; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }

        System.out.println(str.substring(0, i+1));
    }
}
