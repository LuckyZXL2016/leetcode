package studyForJob;

/**
 * Created by ZXL on 2020/3/31.
 */
public class test5 {

    // 阿拉伯转中文数字
    private static String alaToCh(String str) {
        String[] s1 = {"零","一","二","三","四","五","六","七","八","九"};
        String[] s2 = {"十","百","千","万","十","百","千","亿","十","百","千"};

        int n = str.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                res += s1[num] + s2[n - 2 - i];
            } else {
                res += s1[num];
            }
        }
        return res;
    }

    // 大数加法
    private static String getSum(String str1, String str2) {
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int sum = (str1.charAt(len1) - '0') + (str2.charAt(len2) - '0') + index;
            if (sum > 9) {
                index = 1;
                sb.append(sum % 9);
            } else {
                index = 0;
                sb.append(sum);
            }
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            int sum = str1.charAt(len1) - '0' + index;
            if (sum > 9) {
                index = 1;
                sb.append(sum % 9);
            } else {
                index = 0;
                sb.append(sum);
            }
            len1--;
        }
        while (len2 >= 0) {
            int sum = str2.charAt(len2) - '0' + index;
            if (sum > 9) {
                index = 1;
                sb.append(sum % 9);
            } else {
                index = 0;
                sb.append(sum);
            }
            len2--;
        }
        if (index == 1) {
            sb.append("1");
            return sb.reverse().toString();
        } else {
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String str = alaToCh("123456");
        String str2 = getSum("1234","123");
        System.out.println(str);
        System.out.println(str2);
    }
}
