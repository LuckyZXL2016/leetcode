package leetCode.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * n * m 的矩阵作为棋盘，每个棋位对应一个二维坐标 (x,y)。
 * 起点(0,0)移动到(n-1,m-1)，棋子可以向相邻的上下左右位置移动，每个坐标最多只能经过一次，
 * 棋盘中散布着若干障碍，是否存在路线，输出所需的最少移动次数，不存在输出0。
 * Created by ZXL on 2019/9/4.
 */
public class dp16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // k个障碍物
        int k = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < k; i++) {
            grid[sc.nextInt()][sc.nextInt()] = 1;
        }
        int[] begin = {0,0};
        int[] end = {n-1,m-1};
        System.out.println(bfs(grid,begin,end));
    }

    private static int bfs(int[][] grid, int[] begin, int[] end) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.offer(begin);
        dp[begin[0]][begin[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    grid[nx][ny] != 1 && dp[nx][ny] == Integer.MAX_VALUE) {
                    dp[nx][ny] = dp[cur[0]][cur[1]] + 1;
                    int[] c = {nx, ny};
                    queue.offer(c);
                }
            }
        }
        return dp[end[0]][end[1]] == Integer.MAX_VALUE ? 0 : dp[end[0]][end[1]];
    }
}
