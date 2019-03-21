package examination.tencent;

/**
 * 给定一个每个元素都是一个字母的矩阵，判断某个字符串是否在这个矩阵存在。要求字符串
 * 中相邻的两个字母在矩阵中也必须是连续的（8个方向均判定为连续）。
 * Created by ZXL on 2019/3/21.
 * 例如：
 * YPWF
 * ATAO
 * GEDT
 * HOLD
 * HOLD -> yes; TED -> yes; FOLD -> no; WATER -> no; PADDLE -> yes
 */
public class t_02 {
    /**
    * 思路：回溯法：首先任意一个点都有可能成为起点，所以要获得任意一点的坐标(位于第几行，第几列)
    * 其次要有一个数组记录这个点是否被访问过，同时要有一个指针来记录字符串中字符的位置。
    * 当某个点成为合法的起点时，即这个点与字符串中第一个字符相等，则可以继续朝八个方向搜索下一个点；
    * 如果这个点不能成为合法的起点，则恢复现场(这个点没有被访问过且字符串指针后退)
    */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || rows < 0 || cols < 0 || str.length <= 0) {
            return false;
        }

        boolean visited[] = new boolean[rows * cols];
        int[] index = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPath(matrix, rows, cols, i, j, str, visited, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean visited[], int[] index) {
        if (index[0] == str.length) {
            return true;
        }

        boolean flag = false;
        //当前点折算到原数组的位置是：row * cols + col
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row * cols + col] && matrix[row * cols + col] == str[index[0]]) {
            index[0]++;    //指针右移
            visited[row * cols + col] = true;

            //第一个点是合法的起点之后开始回溯:八个方向进行搜索
            flag =  isPath(matrix, rows, cols, row - 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row - 1, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row - 1, col + 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col + 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col + 1, str, visited, index);
            if (!flag) {        //恢复现场
                index[0]--;
                visited[row * cols + col] = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String str = "ABCDEFGHI";
        char[] matrix = str.toCharArray();
        String str2 = "BFH";
        char[] c = str2.toCharArray();
        System.out.println(new t_02().hasPath(matrix, 3, 3, c));
    }
}
