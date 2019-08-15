package examination.pufa;

import java.util.Scanner;

/**
 * 输出字的个数
 * Created by ZXL on 2019/8/15.
 */
public class p_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int n = countWords(str);
        System.out.println(n);
    }

    private static int countWords(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int count = 0;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= '0' && c <= '9' || c >= 'a' &&  c <= 'z' || c >= 'A' && c <= 'Z') {
                count++;
            } else {
                if (Character.isLetter(c)) {
                    count++;
                } else {
                    count++;
                }
            }
        }

        return count;
    }
}
