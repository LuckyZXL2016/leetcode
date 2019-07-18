package leetCode.array;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k个最大的元素。请注意，你需要找的是数组排序
 * 后的第 k个最大的元素，而不是第 k个不同的元素。
 * Created by ZXL on 2019/7/18.
 * <p>
 * 示例 :
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class array12 {

    
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k - 1];
    }
}
