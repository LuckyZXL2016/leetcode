package examination.tencent;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 题目地址：https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Created by ZXL on 2019/6/10.
 */
public class t_14 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int num = 0;
        if (chars[0] == '-') {
            for (int i = 1; i < len; i++) {
                if (chars[i] - '0' <= 9 && chars[i] - '0' >= 0) {
                    if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10) && (chars[i] - '0') > 8) {
                        return Integer.MIN_VALUE;
                    }
                    num = '0' - chars[i] + num * 10;
                } else {
                    break;
                }
            }

        } else if (chars[0] == '+') {
            for (int i = 1; i < len; i++) {
                if (chars[i] - '0' <= 9 && chars[i] - '0' >= 0) {
                    if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10) && (chars[i] - '0') > 7) {
                        return Integer.MAX_VALUE;
                    }
                    num = chars[i] -'0' + num * 10;
                } else {
                    break;
                }
            }
        } else if (chars[0] - '0' <= 9 && chars[0] - '0' >= 0) {
            for (int i = 0; i < len; i++) {
                if (chars[i] - '0' <= 9 && chars[i] - '0' >= 0) {
                    if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10) && (chars[i] - '0') > 7) {
                        return Integer.MAX_VALUE;
                    }
                    num = chars[i] -'0' + num * 10;
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("4193"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("+10"));
    }
}
