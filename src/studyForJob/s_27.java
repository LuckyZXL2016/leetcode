package studyForJob;

import java.util.Scanner;

/**
 * 地址：https://www.cnblogs.com/zzlback/p/8596677.html
 * 0-1 背包问题
 * Created by ZXL on 2019/8/30.
 */
public class s_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int res = getMaxValue(w, v, weight);
        System.out.println(res);
    }

    private static int getMaxValue(int[] w, int[] v, int weight) {
        int n = w.length;

        int[][] dp = new int[n + 1][weight + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                if (w[i-1] <= j) {
                    dp[i][j] = Math.max(v[i-1] + dp[i - 1][j - w[i-1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][weight];
    }
}
