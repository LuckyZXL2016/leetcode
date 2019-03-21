package examination.byteDance;

import java.util.Scanner;

/**
 * 有N根绳子，第i根长为Li，现需要m根等长绳子。
 * 你可以对n根绳子进行任意剪裁(不能拼接)，计算出这m根绳子最长的长度是多少?
 * 求解思路：二分法
 * Created by ZXL on 2019/3/21.
 * <p>
 * 输入描述：
 * 第一行包括2个正整数N、M，表示N根原始的绳子，和最终需要M根绳子数
 * 第二行包含N个整数，第i个整数Li表示第i根绳子的长度
 * 其中   1 <= N、M <=100000；  0 < Li < 1000000000
 * 输出描述：
 * 对每一个测试用例，输出一个数字 表示裁剪后最长的长度，保留两位小数。
 * <p>
 * 示例：
 * 输入
 * 3 4
 * 3 5 4
 * 输出
 * 2.50
 * 说明：第一根和第三根分别裁剪出一根2.50长度的绳子，第二根剪成2根2.50长度的绳子，
 * 刚好4根
 */
public class b_03 {
    // 判断能截成多少段
    public int checkValue(int n, int[] len, double mid) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += len[i] / mid;
        }
        return sum;
    }

    public double getAns(int n, int[] len, int m) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += len[i];
        }
        double l, r, mid, ans;
        ans = 0;
        l = 0;
        r = sum;
        while (r - l > 1e-4) {
            mid = (l + r) / 2.0;
            if (mid == 0) {
                break;
            }
            if (checkValue(n, len, mid) >= m) {
                l = mid;
                ans = mid;
            } else {
                r = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        b_03 example = new b_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = sc.nextInt();
        }
        System.out.println(String.format("%.2f", example.getAns(n, len, m)));
    }
}
