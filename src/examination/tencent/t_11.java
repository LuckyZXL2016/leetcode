package examination.tencent;

import java.util.Scanner;

/**
 * 画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表
 * 示。小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会
 * 选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;如果对角线的方向形如'\',即斜率为-1,小Q
 * 会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
 * 如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
 * 小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50), 表示画板的长宽。
 * 接下来的N行包含N个长度为M的字符串, 其中包含字符'B','Y','G','X',分别表示蓝色,黄色,绿色,
 * 空白。整个表示小Q要完成的作品。
 * 输出描述:
 * 输出一个正整数, 表示小Q最少需要多少次操作完成绘画。
 * Created by ZXL on 2019/4/4.
 * <p>
 * 输入例子1:
 * 4 4
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 * 输出例子1:
 * 3
 * 例子说明1:
 * XXXX   ->   YXXX   ->   YXXB   ->   YXXB
 * XXXX        XYXX        XYBX        XYGX
 * XXXX        XXYX        XBYX        XBYY
 * XXXX        XXXY        BXXY        BXXY
 */
public class t_11 {
    static char[][] chs = new char[50][50];
    static int n;
    static int m;

    private static void dfs_B(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m && (chs[i][j] == 'B' || chs[i][j] == 'G')) {
            if (chs[i][j] == 'B') {
                chs[i][j] = 'X';
            } else if (chs[i][j] == 'G') {
                chs[i][j] = 'Y';
            }
            dfs_B(i + 1, j - 1);
            dfs_B(i - 1, j + 1);
        }
        return;
    }

    private static void dfs_Y(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m && (chs[i][j] == 'Y' || chs[i][j] == 'G')) {
            if (chs[i][j] == 'Y') {
                chs[i][j] = 'X';
            } else if (chs[i][j] == 'G') {
                chs[i][j] = 'B';
            }
            dfs_Y(i - 1, j - 1);
            dfs_Y(i + 1, j + 1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                chs[i][j] = str.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chs[i][j] == 'B') {
                    dfs_B(i, j);
                    count++;
                } else if (chs[i][j] == 'Y') {
                    dfs_Y(i, j);
                    count++;
                } else if (chs[i][j] == 'G') {
                    dfs_B(i, j);
                    count++;
                    dfs_Y(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
