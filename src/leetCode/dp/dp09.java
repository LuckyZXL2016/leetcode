package leetCode.dp;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * Created by ZXL on 2019/3/11.
 * <p>
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class dp09 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }
}
