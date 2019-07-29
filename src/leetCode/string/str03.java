package leetCode.string;

/**
 * 给你一个数N，输出N!的值。N的范围不限定。
 * 两个大整数相乘
 * Created by ZXL on 2019/7/29.
 */
public class str03 {

    // 大整数相乘
    private String mul(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length + c2.length;
        char[] c = new char[len];
        for (int i = c1.length - 1; i >= 0; i--) {
            int index = len - 1;
            // 保持进位
            int res = 0;
            for (int j = c2.length - 1; j >= 0; j--) {
                int temp = (c1[i] - '0') * (c2[j] - '0') + c[index] + res;
                res = temp / 10;
                c[index--] = (char)(temp % 10);
            }
            c[index] = (char)res;
            len--;
        }

        // c中字符加上'0'
        for (int i = 0; i < c.length; i++) {
            c[i] += '0';
        }
        String s = new String(c);

        if (c[0] == '0') {
            return s.substring(1);
        }
        return s;
    }

    // 给你一个数N，输出N!的值。N的范围不限定。
    private String getN(int n) {
        String s = "1";
        Integer t = null;
        for (int i = 2; i <= n; i++) {
            t = i;
            s = mul(s, t.toString());
        }
        return s;
    }

    public static void main(String[] args) {
        str03 example = new str03();
        System.out.println(example.getN(10));
    }
}
