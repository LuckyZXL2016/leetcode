package examination.zhaohang;

import java.util.Scanner;

/**
 * 蛋糕各个部分高低不齐，希望蛋糕各个部分一样高。将蛋糕分成了等距的n块，每一块都是一样
 * 宽，高度为hi。每一刀选择一个高度平行切蛋糕，在这个高度以上的部分都会被切下来扔掉，直
 * 到所有块都有一样的高度为止。
 * 为了不过于浪费，每一刀切除的蛋糕体积不得超过k（1块高度为1的蛋糕为一个单位体积），希望
 * 用最少的刀数完成高度调整。
 * Created by ZXL on 2019/3/20.
 * <p>
 * 输入描述：
 * 第一行两个整数n，k
 * 第二行n个整数hi，表示第i块蛋糕的初始高度hi。
 * 1<=n，hi<=200000，n<=k<=1000000000
 * 输出描述：
 * 一个整数ans，表示最少的刀数。
 * 输入
 * 3 3
 * 2 3 5
 * 输出
 * 2
 */
public class z_02 {
    public int getMinOfK(int[] arr, int k) {
        int min = arr[0], sum = arr[0];
        for (int i = 1; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        int remain = sum - min * arr.length;
        int res = (int)Math.ceil(remain * 1.0 / k);
        return res;
    }

    public static void main(String[] args) {
        z_02 example = new z_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(example.getMinOfK(arr, k));
    }
}
