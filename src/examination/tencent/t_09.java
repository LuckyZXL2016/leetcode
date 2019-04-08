package examination.tencent;

import java.util.Scanner;

/**
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌,现在小Q想用这些歌组成一个总长度正
 * 好为K的歌单,每首歌最多只能在歌单中出现一次,在不考虑歌单内歌曲的先后顺序的情况下,请
 * 问有多少种组成歌单的方法。
 * 输入描述:
 *  每个输入包含一个测试用例。
 *  每个测试用例的第一行包含一个整数,表示歌单的总长度K(1<=K<=1000)。
 *  接下来的一行包含四个正整数,分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌
 *  的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * 输出描述:
 *  输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
 * Created by ZXL on 2019/4/4.
 *
 * 输入例子1:
 *  5
 *  2 3 3 3
 * <p>
 * 输出例子1:
 *  9
 */

// 参考地址：https://www.nowcoder.com/questionTerminal/f3ab6fe72af34b71a2fd1d83304cbbb3
public class t_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalLength = sc.nextInt();
        int A = sc.nextInt();
        int num_A = sc.nextInt();
        int B = sc.nextInt();
        int num_B = sc.nextInt();
        int[] lengths = new int[num_A + num_B];
        for (int i = 0; i < num_A; i++) {
            lengths[i] = A;
        }
        for (int i = num_A; i < num_A + num_B; i++) {
            lengths[i] = B;
        }
        int[][] dp = new int[totalLength + 1][num_A + num_B];
        for (int j = 0; j < num_A + num_B; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < totalLength + 1; i++) {
            for (int j = 0; j < num_A + num_B; j++) {
                if (j == 0) {
                    if (lengths[0] == i) dp[i][0] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + (lengths[j] <= i ? dp[i - lengths[j]][j - 1] : 0);
                }
            }
        }
        System.out.println(dp[totalLength][num_A + num_B - 1]);
    }
}
