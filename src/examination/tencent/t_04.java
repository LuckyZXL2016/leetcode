package examination.tencent;

import java.util.Scanner;

/**
 * 一个数组，只有一个数是重复的找出这个数。要求时间O(n)，空间O(1)。
 * 数组中所有数字都在范围[0, N-1]
 * Created by ZXL on 2019/3/22.
 * <p>
 */
public class t_04 {
    public int searchDulNum(int[] a) {
        for (int i = 0; i < a.length; i++) {
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    return a[i];
                } else {
                    int temp = a[i];
                    a[i] = a[temp];
                    a[temp] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        t_04 example = new t_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(example.searchDulNum(a));
    }
}
