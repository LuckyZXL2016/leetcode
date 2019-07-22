package leetCode.string;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * Created by ZXL on 2019/7/22.
 * <p>
 * 示例 :
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
public class str02 {
    private char[] reverseString(char[] s) {
        if (s == null || s.length == 0) return null;

        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
        return s;
    }

    public String reverseWords(String s) {
        if (s == null) return null;
        if (s.length() == 0) return "";

        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(reverseString(strings[i].toCharArray()));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        str02 exam = new str02();
        String s = "Let's take LeetCode contest";
        System.out.println(exam.reverseWords(s));
    }
}
