package studyForJob;

import java.util.HashSet;

/**
 * 回文串
 * Created by ZXL on 2019/8/30.
 */
public class s_17 {

    // 最长回文串的长度
    private static int longestPalindrome(String str) {
        if (str == null || str.length() == 0) return 0;
        HashSet<Character> hashSet = new HashSet<>();

        int count = 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (!hashSet.contains(c)) {
                hashSet.add(c);
            } else {
                hashSet.remove(c);
                count++;
            }
        }

        return hashSet.isEmpty() ? 2 * count : 2 * count + 1;
    }

    // 最长回文子串
    private static String longestPalindrome2(String str) {
        if (str == null || str.length() == 0) return null;

        int len = str.length();
        int[][] dp = new int[len][len];

        int start = 0, max = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                max = 2;
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                int j = i + l - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    max = l;
                }
            }
        }
        return str.substring(start, start + max);
    }

    // 最长回文子串--2
    private static String longestPalindrome2_2(String str) {
        if (str == null || str.length() == 0) return null;

        int len = str.length();
        int[][] dp = new int[len][len];
        int max = 1, start = 0;
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        start = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str.substring(start, start + max);
    }

    // 验证回文子串
    // 输入: "A man, a plan, a canal: Panama"  输出: true
    // 只考虑字母和数字字符，可以忽略字母的大小写
    private static boolean longestPalindrome3(String str) {
        if (str == null || str.length() == 0) return false;

        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    // 最长回文子序列
    private static int longestPalindrome4(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome2(str));
        System.out.println(longestPalindrome2_2(str));
        System.out.println(longestPalindrome3(str));
        System.out.println(longestPalindrome4(str));
    }
}
