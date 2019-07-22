package leetCode.array;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * Created by ZXL on 2019/7/22.
 *
 * 示例 ：
 *  输入：["h","e","l","l","o"]
 *  输出：["o","l","l","e","h"]
 */
public class array15 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
    }
}
