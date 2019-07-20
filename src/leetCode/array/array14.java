package leetCode.array;

/**
 * 给定长度为 n的整数数组 nums，其中 n > 1，返回输出数组 output，其中 output[i] 
 * 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * Created by ZXL on 2019/7/20.
 *
 * 示例:
 *  输入: [1,2,3,4]
 *  输出: [24,12,8,6]
 * 说明：O(n)时间复杂度，常数空间复杂度
 */
public class array14 {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(productExceptSelf(nums));
    }
}
