package examination.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * beautifulNumber,小数据集
 * 判断一个数在几进制下是beautiful的
 * Created by ZXL on 2019/6/24.
 */
public class g_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            System.out.println("Case #" + (i + 1) + ":" + beautiful(n));
        }
    }

    private static int beautiful(int n) {
        for (int radix = 2; radix < n; radix++) {
            // if n is 11 in radix, return radix
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }
        throw new IllegalStateException("Should not reach here");
    }

    private static boolean isBeautiful(int n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                return false;
            }
            n /= radix;
        }
        return true;
    }
}
