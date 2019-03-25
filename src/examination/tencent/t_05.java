package examination.tencent;

import java.util.Scanner;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * Created by ZXL on 2019/3/25.
 *
 * 输入描述：
 *  输入一个字符串,包括数字字母符号,可以为空。
 * 输出描述：
 *  如果是合法的数值表达则返回该数字，否则返回0。
 * 输入例子：
 *  +2147483647
 *     1a33
 * 输出例子：
 *  2147483647
 *      0
 *
 */
public class t_05 {
    public int strToInt(String str) {
        int sum = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] - '0' == 0) {
                    return 0;
                }
            } else {
                if (chars[i] -'0' < 0 || chars[i] - '9' > 9) {
                    return 0;
                }
            }
        }
        if (chars[0] == '+' || chars[0] == '-' || (chars[0] - '0' >= 0 && chars[0] - '9' <= 0)) {
            for (int i = 1; i < chars.length; i++) {
                sum = sum * 10 + (chars[i] - '0');
            }
        }
        if (chars[0] == '-') {
            return -sum;
        } else if (chars[0] == '+') {
            return sum;
        } else {
            sum = 0;
            for (int i = 0; i < chars.length; i++) {
                sum = sum * 10 + sum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        t_05 example = new t_05();
        Scanner sc = new Scanner(System.in);
        System.out.println(example.strToInt(sc.next()));
    }
}
