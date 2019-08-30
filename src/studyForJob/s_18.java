package studyForJob;

/**
 * 两个数组
 * Created by ZXL on 2019/8/30.
 */
public class s_18 {
    // 返回最长公共子序列
    private static int getLcsLength(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    // 返回最长公共子串
    private static String getLCS(String str1, String str2) {
        if (str1 == null || str2 == null) return null;

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len2; i++) {
            dp[0][i] = (str1.charAt(0) == str2.charAt(i)) ? 1 : 0;
        }
        for (int i = 0; i < len1; i++) {
            dp[i][0] = (str1.charAt(i) == str2.charAt(0)) ? 1 : 0;
        }

        int maxLen = 0, maxEnd = 0;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        maxEnd = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int start = maxEnd - maxLen + 1;
        return str1.substring(start, maxEnd + 1);
    }

    public static void main(String[] args) {
        String str1 = "helloworld";
        String str2 = "hwewegallgeo";
        System.out.println(getLcsLength(str1, str2));
        System.out.println(getLCS(str1, str2));
    }
}
