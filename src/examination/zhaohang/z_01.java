package examination.zhaohang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个长度为n的数列，每个数字可以吃掉自己左边或者右边的数字，被吃掉的数字会
 * 让吃掉他的数字减去自身的值，比如数字3吃掉了数字2，那么3就变成(3-2)==1了。
 * 你可以决定哪些数字吃或者被吃，直到最后只剩下一个数字为止，这个数字最大是多少。
 * Created by ZXL on 2019/3/20.
 *
 * 输入描述：
 *  第一行一个整数n，表示数列的长度。
 *  第二行n个整数ai，表示第i号位置的数字是ai
 * 输出描述
 *  一个整数ans，表示剩下的这个数字
 * 输入：
 *  5
 *  -1 -2 3 -4 -5
 * 输出
 *  15
 */
public class z_01 {
    public int getMaxValue(int[] arr) {
        int max = 0;
        int num = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] < 0) {
                num++;
                arr[i] = 0 - arr[i];
            }
            max += arr[i];
        }
        Arrays.sort(arr);
        if (num == 0 || num == arr.length) {
            max = max - 2 * arr[0];
        }
        return max;
    }

    public static void main(String[] args) {
        z_01 example = new z_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(example.getMaxValue(arr));
    }
}
