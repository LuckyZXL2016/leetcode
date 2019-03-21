package examination.byteDance;

import java.util.Scanner;

/**
 * 规则：
 * 1.三个同样的字母连在一起，一定是拼写错误，去掉一个就好了。比如:helllo --> hello
 * 2.两对一样的字母(AABB型)连在一起，一定是拼写错误，去掉第二对的第一个字母。比如:helloo --> hello
 * 3.上面的规则优先从左到右匹配，即如果是AABBCC型，应优先考虑修复AABB为AABCC。
 * 输入：
 * 一串字符串
 * 输出：
 * 修正后的字符串
 * 求解思路：遍历一次字符串即可
 * Created by ZXL on 2019/3/20.
 */
public class b_01 {
    public char[] getArray(String s) {
        char[] newArr = new char[s.length() + 1];
        char[] oldArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            newArr[i] = oldArr[i];
        }
        newArr[s.length()] = ' ';
        return newArr;
    }

    public String getCorString(String s) {
        char[] chars = getArray(s);
        int i = 0;
        int j;
        int count1 = 0; // 规则1，三个同样的字母连续
        int count2 = 0; // 规则2，两队一样的字母连在一起
        int aa = 0; // 作用于规则2

        while (chars[i] != ' ') {
            if (i == 0) {
                count1 = 1;
                count2 = 0;
                aa = 0;
            } else {
                if (chars[i] == chars[i - 1]) {
                    count1++;
                    if (count1 == 2) {
                        aa = 0;
                        count2++;
                    }
                } else {
                    count1 = 1;
                    aa++;
                    if (aa == 2) {
                        count2 = 0;
                    }
                }
            }
            if (count1 == 3) {
                j = i;
                while (chars[j + 1] != ' ') {
                    chars[j] = chars[j + 1];
                    j++;
                }
                chars[j] = ' ';
                i = i - 2;
                count1 = 1;
                count2 = 0;
                aa = 0;
                continue;
            }
            if (count2 == 2) {
                j = i;
                while (chars[j + 1] != ' ') {
                    chars[j] = chars[j + 1];
                    j++;
                }
                chars[j] = ' ';
                i = i - 3;
                count1 = 1;
                count2 = 0;
                aa = 0;
                continue;
            }
            i++;
        }
        return String.valueOf(chars).trim();
    }

    public static void main(String[] args) {
        b_01 example = new b_01();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(example.getCorString(s));
    }
}
