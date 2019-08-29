package examination.huawei;

import java.util.Scanner;

/**
 * 两个数组的最长公共子序列
 * Created by ZXL on 2019/8/28.
 */
public class h_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < len; j++) {
            b[j] = sc.nextInt();
        }

        int res = getDeletedNum(a, b);
        System.out.println(res);
    }

    private static int getDeletedNum(int[] a, int[] b) {
        int len = a.length;
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        int res = len - dp[len][len];
        return res;
    }

}
