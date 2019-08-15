package examination.pufa;

import java.util.Scanner;

/**
 * 给出一个字符串，由不同的单词用空格隔开的，然后呢，把这些单词的首字母取出并大写输出
 * 如输入：hello world，输出：HW，不过代码都是要求你实现多行输入的输出的，输入0则停止输入。
 * Created by ZXL on 2019/8/15.
 */
public class p_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] split = str.split(" ");
        int len = split.length;
        String res = "";
        for (int i = 0; i < len; i++) {
            res += (split[i].charAt(0)+"").toUpperCase();
        }
        System.out.println(res);
    }
}
