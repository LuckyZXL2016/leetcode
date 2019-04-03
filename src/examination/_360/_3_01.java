package examination._360;

import java.util.Scanner;

/**
 * 最近一款吃鸡类型的游戏火爆全球。在组队模式下，你可以邀请自己的好友组建自己的小队，
 * 并选择是否填充（是否同意和非好友游玩），然后加入游戏。现在有A个单人队伍，B个双人队
 * 伍，C个三人队伍，D个四人队伍，并且全都同意填充，请问最多能组成多少个四人队伍。
 * Created by ZXL on 2019/4/3.
 *
 * 输入
 * 第一行一个正整数T，表示数据组数。（1≤T≤100）
 * 接下来T行，每行四个非负整数，A，B，C，D。（0≤A, B, C, D≤150）
 * 输出
 * 共T行，每行输出一个队伍数。
 * 样例输入
 *  4
 *  1 2 3 4
 *  4 3 2 1
 *  2 2 2 1
 *  0 2 0 1
 * 样例输出
 *  6
 *  5
 *  4
 *  2
 */
public class _3_01 {
    public int getNumTeam(int na, int nb, int nc, int nd) {
        int num = nd;
        while (nb >= 2) {
            nb = nb - 2;
            num++;
        }
        while (na >= 1 && nc >= 1) {
            na = na - 1;
            nc = nc - 1;
            num++;
        }
        while (nb >= 1 && na >= 2) {
            nb = nb - 1;
            na = na - 2;
            num++;
        }
        return num + na / 4;
    }

    public static void main(String[] args) {
        _3_01 example = new _3_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
            array[i][2] = sc.nextInt();
            array[i][3] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(example.getNumTeam(array[i][0], array[i][1], array[i][2], array[i][3]));
        }
    }
}
