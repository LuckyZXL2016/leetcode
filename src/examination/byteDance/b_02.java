package examination.byteDance;

import java.util.Scanner;

/**
 * n个人参加比赛，结束后每个人一个分数。
 * 领奖时所有人依次排成一圈，第一个和第n个相邻。
 * 要求:
 * 1.如果某个人的分数比旁边的人高，那么奖品数量也要比他多。
 * 2.每个至少得一个奖品。
 * 问最少应该准备多少个奖品?
 * 求解思路：化环为直，动态调整循环次数
 * Created by ZXL on 2019/3/21.
 */
public class b_02 {
    public int getAns(int n, int[] grade) {
        int sum = 0;
        int[] sums = new int[n + 2];
        int i;
        int flag;
        for (i = 0; i <= n + 1; i++) {
            sums[i] = 1;
        }

        do {
            flag = 0;
            // 与左边比较
            for (i = 1; i <= n; i++) {
                if (grade[i] > grade[i - 1] && sums[i] <= sums[i - 1]) {
                    sums[i] = sums[i] + 1;
                    flag = 1;
                }
            }
            // 与右边比较
            for (i = 1; i <= n; i++) {
                if (grade[i] > grade[i + 1] && sums[i] <= sums[i + 1]) {
                    sums[i] = sums[i] + 1;
                    flag = 1;
                }
            }
            sums[0] = sums[n];
            sums[n + 1] = sums[1];
        } while (flag == 1);
        for (i = 1; i <= n; i++) {
            sum += sums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        b_02 example = new b_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] grade = new int[n+2];
        for (int i = 0; i < n; i++) {
            grade[i] = sc.nextInt();
        }
        grade[n] = grade[0];
        grade[n+1] = grade[1];
        System.out.println(example.getAns(n, grade));
    }
}
