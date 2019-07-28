package examination.pdd;

import java.util.Scanner;

/**
 * 给定一个字符串数组(字符串长度和数组的长度均大于1且小于1024)，所有字符均为大写字母。
 * 请问，给定的字符串数组是否能通过更换数组中元素的顺序，从而首尾相连，形成一个环，环上
 * 相邻字符串首尾衔接的字符相同。
 * 输入描述：
 *  一行输入，空格分隔，表示字符串数组。
 *  一行输出，返回true或者false，表示是否可以形成环。
 * Created by ZXL on 2019/7/28.
 *
 * 输入:
 *  CAT TIGER RPC
 * 输出:
 *  true
 */
public class p_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        String[] strs = inputStr.split(" ");
        int[] heads = new int[26];
        int[] tails = new int[26];
        for (String str : strs) {
            heads[str.charAt(0) - 'A'] += 1;
            tails[str.charAt(str.length()-1) - 'A'] += 1;
        }
        for (int i=0; i<26; i++) {
            if (heads[i] != tails[i]) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
