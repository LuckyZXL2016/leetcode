package examination.niuke;

import java.util.Scanner;

/**
 * 【走斜线】
 * 有天他来到一张方格地图上，整张地图可以看做一个二维坐标轴。牛牛此刻处于原点（0,0），
 * 他想要到点（x,y）去。牛牛有强迫症，他规定自己必须恰好k步走到点(x,y)，中途可以经过
 * 任何点包括（x,y），但是第k步一定要到达（x,y）。一步有八种走法，直线东（+1,0）
 * 南（0,-1）西（-1,0）北（0,+1），斜线东南（+1,-1）东北（+1,+1）西南（-1,-1）
 * 西北（-1,+1）。牛牛会在能k步到达目的地的基础下尽量走斜线，你能计算出牛牛到底走了多少条斜线吗？
 * 输入描述：
 * 第一行一个整数T，代表数据组数。
 * 每组数据给出三个整数x，y，k。
 * 输出描述：
 * 对于每组数据，单独一行输出一个整数。
 * 如果牛牛可以在第k步的时候到达(x,y)，输出牛牛走的斜线数量。
 * 如果牛牛不能到达，输出-1。
 * Created by ZXL on 2019/3/20.
 * <p>
 * 示例1：
 * 输入
 * 2
 * 2 3 4
 * 7 7 9
 * 输出
 * 3
 * 9
 */
public class n_01 {
    /**
     * 要到达目的地花费的最小步数是x和y的最大值，如果k小于这个值就一定到不了。如果k溢出了，那么在整
     * 个k步里，最多只会走两条直线。分别是如下三种情况（令x<=y）：
     * 0条直线（y-x）是偶数且（k-x）是偶数；1条直线（y-x）是奇数；2条直线（y-x）是偶数且（k-x）是奇数。
     */
    public int getValue(int x, int y, int k) {
        int t, ans = k;
        if (x > y) {
            t = x;
            x = y;
            y = t;
        }
        if (y > k) {
            return -1;
        }
        if ((y - x) % 2 == 1) ans--;
        if ((y - x) % 2 == 0 && (k - x) % 2 == 1) ans -= 2;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n_01 example = new n_01();
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            res[i] = example.getValue(x, y, k);
        }
        for (int m = 0; m < n; m++) {
            System.out.println(res[m]);
        }
    }
}
