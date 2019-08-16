package examination.byteDance;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 三十六进制加法
 * Created by ZXL on 2019/8/15.
 */
public class b_06 {
    static Character[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                               'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                               'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static List<Character> list = Arrays.asList(nums);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        String res = add36(str1, str2);
        System.out.println(res);
    }

    private static String add36(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int len1 = chars1.length - 1;
        int len2 = chars2.length - 1;
        int tmp = 0;    // 进位
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            char c1 = chars1[len1];
            char c2 = chars2[len2];
            int index1 = list.indexOf(c1);
            int index2 = list.indexOf(c2);
            int sum = index1 + index2 + tmp;
            if (sum >= 36) {
                tmp = 1;
                sb.append(list.get(sum % 36));
            } else {
                tmp = 0;
                sb.append(list.get(sum));
            }
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            int sum = list.indexOf(chars1[len1]) + tmp;
            if (sum >= 36) {
                tmp = 1;
                sb.append(list.get(sum % 36));
            } else {
                tmp = 0;
                sb.append(list.get(sum));
            }
            len1--;
        }
        while (len2 >= 0) {
            int sum = list.indexOf(chars2[len2]) + tmp;
            if (sum >= 36) {
                tmp = 1;
                sb.append(list.get(sum % 36));
            } else {
                tmp = 0;
                sb.append(list.get(sum));
            }
            len2--;
        }
        if (tmp != 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
