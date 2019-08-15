package examination.pufa;

import java.util.Scanner;

/**
 * 输入 n 和 b , 找出 1 到 n 中被 b 整除的个数
 * Created by ZXL on 2019/8/15.
 *
 * 例：输入 6 3 输出 2
 */
public class p_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int div = sc.nextInt();

        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (i % div == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
