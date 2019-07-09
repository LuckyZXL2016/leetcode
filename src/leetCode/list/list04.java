package leetCode.list;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * Created by ZXL on 2019/7/9.
 * <p>
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class list04 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
        }

        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int num = 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                matrix[r1][c] = num;
                num++;
            }
            for (int r = r1 + 1; r <= r2; r++) {
                matrix[r][c2] = num;
                num++;
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c >= c1; c--) {
                    matrix[r2][c] = num;
                    num++;
                }
                for (int r = r2 - 1; r >= r1 + 1; r--) {
                    matrix[r][c1] = num;
                    num++;
                }
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }
}
