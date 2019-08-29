package studyForJob;

import java.util.Arrays;
import java.util.List;

/**
 * 三十六进制加法
 * Created by ZXL on 2019/8/29.
 */
public class s_04 {
    private static Character[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static List<Character> list = Arrays.asList(array);

    private static String get36Add(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int len1 = chars1.length - 1;
        int len2 = chars2.length - 1;

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int num1 = list.indexOf(chars1[len1]);
            int num2 = list.indexOf(chars2[len2]);

            int sum = num1 + num2 + index;
            if (sum >= 36) {
                index = 1;
                sb.append(list.get(sum % 36));
            } else {
                index = 0;
                sb.append(list.get(sum));
            }
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            int sum = list.indexOf(chars1[len1]) + index;
            if (sum >= 36) {
                index = 1;
                sb.append(list.get(sum % 36));
            } else {
                index = 0;
                sb.append(list.get(sum));
            }
            len1--;
        }
        while (len2 >= 0) {
            int sum = list.indexOf(chars2[len2]) + index;
            if (sum >= 36) {
                index = 1;
                sb.append(list.get(sum % 36));
            } else {
                index = 0;
                sb.append(list.get(sum));
            }
            len2--;
        }
        if (index == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "123ABC";
        String str2 = "111111";
        System.out.println(get36Add(str1, str2));
    }
}
