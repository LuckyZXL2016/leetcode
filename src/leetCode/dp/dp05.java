package leetCode.dp;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * Created by ZXL on 2019/3/7.
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class dp05 {
    private static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] codes = s.toCharArray();
        int n = s.length();
        // memo[i] 表示字符串中第 i 位数字与其之后数字的组成的编码总数
        int[] memo = new int[n];
        if (codes[n - 1] != '0') {
            memo[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            // '0' 需要与其前一位一起考虑，不单独考虑
            if (codes[i] == '0') {
                continue;
            }
            // 判断与后面的数字的组合是否小于 26
            if (codes[i] == '1' || (codes[i] == '2' && codes[i + 1] <= '6')) {
                if (i == n - 2) {
                    memo[i] = memo[i + 1] + 1;
                } else {
                    // 以 i 位数字开头的编码总和其实就是其后两位数字各自的编码之和
                    memo[i] = memo[i + 1] + memo[i + 2];
                }
            } else {
                memo[i] = memo[i + 1];
            }
        }
        return memo[0];
    }

    private static int numDecodings2(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        // dp[i]为第 i位后编码之和
        int[] dp = new int[len];

        char[] chars = s.toCharArray();
        if (chars[len - 1] == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (chars[i] == '1' || chars[i] == '2' && chars[i + 1] <= '6') {
                if (i == len - 2) {
                    dp[i] = dp[i + 1] + 1;
                } else {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings2("12"));
    }
}
