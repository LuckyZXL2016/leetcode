package examination.tencent;

import java.util.Scanner;

/**
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前
 * 一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃
 * 多少块巧克力
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量
 * M(N<=M<=100000)。
 * 输出描述:
 * 输出一个数表示小Q第一天最多能吃多少块巧克力。
 * Created by ZXL on 2019/4/4.
 * <p>
 * 输入例子1:
 * 3 7
 * 输出例子1:
 * 4
 */

// 参考思路：https://blog.csdn.net/lsh159357/article/details/81143537
// 依次查找合适的块数
public class t_08 {
    public int sumChocolate(int num, int day) {
        int sum = 0;
        for (int i = 1; i <= day; i++) {
            sum = sum + num;
            num = (int) Math.ceil((double) num / 2);
        }
        return sum;
    }

    public int searchMaxChocolate(int total, int day) {
        int first = 1;
        int last = total;
        int sum = 0;
        int mid = (first + last) / 2;
        ;

        if (day == total)
            return 1;
        while (first <= last) {
            sum = sumChocolate(mid, day);
            if (sum < total) {
                first = mid + 1;
            } else if (sum == total) {
                return mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        t_08 example = new t_08();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        System.out.println(example.searchMaxChocolate(M, N));
    }
}
