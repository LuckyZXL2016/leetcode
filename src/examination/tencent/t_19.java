package examination.tencent;

import java.util.Scanner;

/**
 * 最大区间
 * 给定一个数组序列，需要求选出一个区间，区间中的最小数*区间所有数的和最后程序输出经过计算后的最大值。
 * Created by ZXL on 2019/9/2.
 * 给定序列[6 2 1]
 * [6]=6*6=36; [2]=2*2=4;  [1]=1*1=1;  [6,2]=2*8=16;   [2,1]=1*3=3;    [6,2,1]=1*9=9;
 */
public class t_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = getMaxSum(nums);
        System.out.println(res);

        int res2 = getMax(nums);
        System.out.println(res2);
    }

    private static int getMaxSum(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        // min[i][j] 区间 i～j 的最小值
        int[][] min = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int max = -1;
        for (int i = 0; i <= len - 1; i++) {
            for (int j = i; j <= len - 1; j++) {
                if (i == j) {
                    min[i][j] = nums[i];
                } else {
                    if (nums[j] < min[i][j-1]) {
                        min[i][j] = nums[j];
                    } else {
                        min[i][j] = min[i][j - 1];
                    }
                }
                max = Math.max(max, min[i][j] * (sum[j+1] - sum[i]));
            }
        }
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                System.out.print(min[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }

    private static int getMax(int[] nums) {
        int n = nums.length;
        int[][] min = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        sum[0] = 0;
        // sum[i]即从第一个数加到第i个数的和，也就是arr[0]+...+arr[i-1]
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int max = -1;
        for (int k = 0; k <= n - 1; k++)
            // 左右下标的差，k==0时,区间内有1个数
            for (int i = 0; i <= n - 1 - k; i++) {
                int j = i + k;
                if (k == 0) {
                    min[i][j] = nums[i];
                } else {
                    if (nums[j] < min[i][j - 1]) {
                        min[i][j] = nums[j];
                    } else {
                        min[i][j] = min[i][j - 1];
                    }
                }
                max = Math.max(max, min[i][j] * (sum[j + 1] - sum[i]));
            }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(min[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }
}
