package leetCode.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * Created by ZXL on 2019/7/9.
 *
 * 示例:
 *  输入: [-2,1,-3,4,-1,2,1,-5,4],
 *  输出: 6
 *  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class array06 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = nums[i] + nums[i-1] > nums[i] ? nums[i] + nums[i-1] : nums[i];
            if (res < nums[i]) {
                res = nums[i];
            }
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
