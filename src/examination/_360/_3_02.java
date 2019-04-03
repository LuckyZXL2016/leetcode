package examination._360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个长度为N的序列A1到AN，现在要对序列进行M次操作，每次操作对序列的前若干
 * 项进行升序或降序排列，求经过这M次操作后得到的序列。
 * 输入
 *  第一行包含两个整数N和M，1≤N，M≤105。
 *  第二行包含N个空格隔开的整数A1到AN，1≤Ai≤109。
 *  接下来M行，每行包含两个整数t和x，0≤t≤1，1≤x≤N。若t=0，则表示对A1到Ax进行升序排列；若t=1，则表示对A1到Ax进行降序排列。操作执行顺序与输入顺序一致。
 * 输出
 *  输出N个空格隔开的整数，即经过M次操作后得到的序列。
 * Created by ZXL on 2019/4/3.
 *
 * 样例输入
 *  4 2
 *  1 2 4 3
 *  1 3
 *  0 2
 * 样例输出
 *  2 4 1 3
 */
public class _3_02 {
    // 升序
    public int[] sortArray(int[] a, int index) {
        int[] b = new int[index];
        for (int i = 0; i < index; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        for (int i = 0; i < index; i++) {
            a[i] = b[i];
        }
        return a;
    }

    // 降序
    public int[] sortArrayR(int[] a, int index) {
        int[] b = new int[index];
        for (int i = 0; i < index; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        int temp = 0;
        for (int i = 0; i < index / 2; i++) {
            temp = b[i];
            b[i] = b[index - i - 1];
            b[index - i - 1] = temp;
        }
        for (int i = 0; i < index; i++) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) {
        _3_02 example = new _3_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[][] M = new int[m][2];
        for (int i = 0; i < m; i++) {
            M[i][0] = sc.nextInt();
            M[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            if (M[i][0] == 0) {
                example.sortArray(a, M[i][1]);
            } else {
                example.sortArrayR(a, M[i][1]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
