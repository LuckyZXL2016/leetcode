package leetCode.dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * Created by ZXL on 2019/3/5.
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class dp01 {
    public static boolean compareNumber(int i, int j, String s) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int max = 1, mid = 0;   // 记录中位数
        int i, j, k = 0;
        // 回文子串为偶数
        while (k < s.length() - 1) {
            i = k;
            j = k + 1;
            while (i >= 0 && j < s.length() && compareNumber(i, j, s)) {
                i--;
                j++;
            }
            // i多减了一次，j多加了一次
            int len = j - i - 1;
            if (len > max) {
                max = len;
                mid = k;
            }
            k++;
        }
        k = 1;
        // 回文子串为奇数
        while (k < s.length() - 1) {
            i = k - 1;
            j = k + 1;
            while (i >= 0 && j < s.length() && compareNumber(i, j, s)) {
                i--;
                j++;
            }
            int len = j - i - 1;
            if (len > max) {
                max = len;
                mid = k;
            }
            k++;
        }
        if (max % 2 == 0) {
            return s.substring(mid - max / 2 + 1, mid + max / 2 + 1);
        } else {
            return s.substring(mid - max / 2, mid + max / 2 + 1);
        }
    }

    private static String getLongestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        int[][] dp = new int[len][len];
        int max = 1;
        int start = 0;
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= len - 1; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return str.substring(start, start + max);
    }

    public static void main(String args[]) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(getLongestPalindrome(s));
    }
}

