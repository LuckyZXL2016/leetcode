package examination.qianxin;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * Created by ZXL on 2019/9/9.
 *
 * 输入："abcabcbb"
 * 输出：3
 * 解释："abc"，其长度为 3
 */
public class q_01 {
    private static int lengthOfLongestLCS(String str) {
        int n = str.length();
        int[] m = new int[256];
        int left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, m[str.charAt(i)]);
            res = Math.max(res, i - left + 1);
            m[str.charAt(i)] = i + 1;
        }
        return res;
    }
    
    private static int lengthOfLongestLCS2(String str) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> m = new HashSet<>();

        while (right < str.length()) {
            if (!m.contains(str.charAt(right))) {
                m.add(str.charAt(right));
                right++;
                res = Math.max(res, m.size());
            } else {
                m.remove(str.charAt(left));
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "aaaaaaaa";
        System.out.println(lengthOfLongestLCS(str1));
        System.out.println(lengthOfLongestLCS2(str1));
    }
}
