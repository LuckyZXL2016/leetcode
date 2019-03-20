package leetCode.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角，
 * 机器人每次只能向下或者向右移动一步。机器人
 * 试图达到网格的右下角。
 * Created by ZXL on 2019/3/6.
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class dp02 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String args[]) {
        System.out.println(uniquePaths(3, 7));
    }
}
