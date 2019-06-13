package leetCode.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * Created by ZXL on 2019/6/13.
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class str01 {
    public static String multiply(String num1, String num2) {
        if (num1 == null && num2 == null) return null;
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len = num1.length() + num2.length();

        char[] c = new char[len];

        for (int i = num1.length() - 1; i >=0; i--) {
            int index = len - 1;
            int res = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (c1[i] - '0') * (c2[j] - '0') + c[index] + res;
                res = sum/ 10;
                c[index--] = (char)(sum % 10);
            }
            c[index] = (char)(res);
            len--;
        }
        for (int i = 0; i < c.length; i++) {
            c[i] += '0';
        }
        String str = new String(c);
        if (c[0] == '0') {
            return str.substring(1);
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }
}
