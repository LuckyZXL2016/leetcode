package examination._360;

import java.util.Scanner;

/**
 * 给定一个1到N的排列A1到AN，每次可以将排列的第一个数移到排列的末尾，假设经过
 * 若干次移动后得到排列B1到BN，那么|B1-1|+|B2-2|+|B3-3|+...+|BN-N|的最小值是多少？
 * 样例解释
 * 经过两次移动后得到排列{1 5 2 4 3}，此时|B1-1|+|B2-2|+|B3-3|+|B4-4|+|B5-5|取得
 * 最小值。
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * 第二行包含N个空格隔开的整数A1到AN。
 * 输出
 * 输出|B1-1|+|B2-2|+|B3-3|+...+|BN-N|的最小值。
 * Created by ZXL on 2019/4/3.
 * 样例输入
 *  5
 *  4 3 1 5 2
 * 样例输出
 * 6
 */
public class _3_03 {
    public int[] getChangeArray(int[] a, int n) {
        int[] b = new int[n];
        b[n - 1] = a[0];
        for (int i = 0; i < n - 1; i++) {
            b[i] = a[i+1];
        }
        return b;
    }

    public int getSum(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] - i - 1);
        }
        return sum;
    }

    public int getMin(int[] a, int n) {
        int min = getSum(a, n);
        for (int i = 0; i < n; i++) {
            a = getChangeArray(a, n);
            int sum = getSum(a, n);
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {
        _3_03 example = new _3_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(example.getMin(a, n));
    }
}
