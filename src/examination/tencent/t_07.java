package examination.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到
 * 纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * 输入描述:
 *  输入包括两行。
 *  第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 *  第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 * 输出描述:
 *  输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 * Created by ZXL on 2019/4/4.
 *
 * 输入例子1:
 *  3
 *  2 7 4
 * 输出例子1:
 *  5
 */
public class t_07 {
    public int getScore(int[] a, int n) {
        int sum = 0;
        Arrays.sort(a);
        int flag = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum = sum + flag * a[i];
            flag = 0 - flag;
        }
        return sum;
    }

    public static void main(String[] args) {
        t_07 example = new t_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(example.getScore(array, n));
    }
}
