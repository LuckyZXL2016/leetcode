package leetCode.dp;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * Created by ZXL on 2019/4/17.
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class dp12 {
    // 思路一
    // 用两个dp数组，其中f[i]表示子数组[0, i]范围内的最大子数组乘积，g[i]表示子数组[0, i]范围内
    // 的最小子数组乘积，初始化时f[0]和g[0]都初始化为nums[0]，其余都初始化为0。那么从数组的第
    // 二个数字开始遍历，那么此时的最大值和最小值只会在这三个数字之间产生，即f[i-1]*nums[i]，
    // g[i-1]*nums[i]，和nums[i]。所以我们用三者中的最大值来更新f[i]，用最小值来更新g[i]，
    // 然后用f[i]来更新结果res即可。
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = g[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(f[i], res);
        }
        return res;
    }

    // 思路二
    // 求最大值，可以看成求被0拆分的各个子数组的最大值。
    // 当一个数组中没有0存在，则分为两种情况：
    //  1.负数为偶数个，则整个数组的各个值相乘为最大值；
    //  2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
    public static int maxProduct2(int[] nums) {
        int a = 1;
        int max = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            a = a * nums[i];
            if (max < a) max = a;
            if (nums[i] == 0) a = 1;
        }
        a = 1;
        for (int i = n - 1; i >= 0; i--) {
            a = a * nums[i];
            if (max < a) max = a;
            if (nums[i] == 0) a = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        str = str.substring(1, n - 1);
        String[] split = str.split(",");
        n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct2(nums));
    }
}
