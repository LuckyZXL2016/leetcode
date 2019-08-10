package leetCode.array;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * Created by ZXL on 2019/8/10.
 * 示例 1:
 *  输入: [1,3,5,4,7]
 *  输出: 3
 *  解释: 最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序
 *  的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 */
public class array16_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 0) return 0;
        if (nums.length == 1) return 1;

        int count = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                count = Math.max(count, i - j);
                j = i;
            }
        }
        count = Math.max(count, nums.length - j);
        return count == 0 ? nums.length : count;
    }
}
