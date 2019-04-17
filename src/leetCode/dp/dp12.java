package leetCode.dp;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * Created by ZXL on 2019/4/17.
 *
 * 示例 1:
 *  输入: [2,3,-2,4]
 *  输出: 6
 *  解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *  输入: [-2,0,-1]
 *  输出: 0
 *  解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
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
            f[i] = Math.max(Math.max(f[i - 1] * nums[i],g[i-1] * nums[i]),nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i],g[i-1] * nums[i]),nums[i]);
            res = Math.max(f[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        str = str.substring(1, n-1);
        String[] split = str.split(",");
        n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxProduct(nums));
    }
}
