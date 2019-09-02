package leetCode.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方
 * 法可以爬到楼顶呢？注意：给定 n 是一个正整数。
 * Created by ZXL on 2019/3/11.
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class dp07 {
    private static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int res = 0, k = 3, a = 1, b = 2;
        while (k <= n) {
            res = a + b;
            a = b;
            b = res;
            k++;
        }
        return res;
    }

    private static int climbStairs2(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(climbStairs2(4));
    }
}
