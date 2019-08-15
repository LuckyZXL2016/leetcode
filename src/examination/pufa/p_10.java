package examination.pufa;

import java.util.Scanner;

/**
 * A,B两个字符串,求在第一个字符串出现,第二个字符串中未出
 * 现的,重复只取第一次出现,输出字符串。
 * Created by ZXL on 2019/8/15.
 */
public class p_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strA = sc.nextLine();
        String strB = sc.nextLine();

        String res = getSim(strA, strB);
        System.out.println(res);
    }

    private static String getSim(String strA, String strB) {
        String res = "";
        for (int i = 0; i < strA.length(); i++) {
            String str = strA.charAt(i) + "";
            if (!strB.contains(str)) {
                res += str;
            }
        }
        return res;
    }
}
