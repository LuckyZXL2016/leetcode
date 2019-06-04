package examination.vivo;

import java.util.Scanner;

/**
 * 编程找出两个字符串中最大公共子字符串,如"abccade","dgcadde"的最大子串为"cad"
 * Created by ZXL on 2019/6/4.
 */
public class v_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        String maxSubString = getSubString(s1, s2);
        System.out.println("maxSubString:" + maxSubString);
    }

    public static String getSubString(String s1, String s2) {
        String sameString = null;
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        boolean isContains = s1.contains(s2);
        if (isContains) {
            return s2;
        } else {
            boolean b1 = false;
            for (int i = 0; i < s2.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    String str = s2.substring(j, s2.length() - i + j);
                    if (s1.contains(str)) {
                        sameString = str;
                        b1 = true;
                        break;
                    }
                }
                if (s2.substring(0, s2.length() - i).length() == 2) {
                    b1 = true;
                    break;
                }
                if (b1 == true) {
                    break;
                }
            }
        }
        return sameString;
    }
}
