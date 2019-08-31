package studyForJob;

import java.util.Scanner;

/**
 * 动态规划
 * 拼满x减10优惠券
 * Created by ZXL on 2019/8/31.
 */
public class s_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = sc.nextInt();
        int[] price = new int[num];
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }
        int[][] dp = new int[num + 1][sum + 1];
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = 20000000;
            }
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j <= price[i - 1]) {
                    dp[i][j] = Math.min(price[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(price[i - 1] + dp[i - 1][j - price[i - 1]], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[num][sum]);
        System.out.println("==================");

        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
