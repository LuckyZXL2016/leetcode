package examination.tencent;

import java.util.Scanner;

/**
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 *
 * 输入描述:
 * 输入包括两个整数n和m(2 <= n <= 109, 1 <= m), 并且满足n能被2m整除。
 *
 * 输出描述:
 * 输出一个整数, 表示前n项和。
 *
 * 输入例子1:
 * 8 2
 *
 * 输出例子1:
 * 8
 * Created by ZXL on 2019/4/4.
 */
/**
 解题思路：一个数列共有n/2m组，每一组的和为m^2
 所以,前n项和为：（n/2m）*(m^2)=m*n/2
*/
public class t_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n < 2 || m < 1) {
            System.out.println(0);
            return;
        }
        if (n % (2 * m) != 0) {
            System.out.println(0);
            return;
        }
        long sum = n / (2 * m) * m;
        sum *= m;
        System.out.println(sum);
    }
}
