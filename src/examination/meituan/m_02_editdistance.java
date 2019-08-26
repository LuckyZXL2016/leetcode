package examination.meituan;

/**
 * 编辑距离
 * https://www.jianshu.com/p/ab77efccfd9b
 * Created by ZXL on 2019/8/26.
 */
public class m_02_editdistance {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "abcd";

        int res = editDistance(str1, str2);
        System.out.println(res);
    }

    private static int editDistance(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < arr1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < arr2.length + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        for (int i = 0; i < arr1.length + 1; i++) {
            for (int j = 0; j < arr2.length + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[arr1.length][arr2.length];
    }
}
