package interview.futu;

/**
 * 求一个数组中的某个元素，其左边的数小于该数，右边的数大于该数。
 * 要求时间复杂度和空间复杂度都为O(n)
 * Created by ZXL on 2019/9/24.
 */
public class f_02 {
    public static void main(String[] args) {
        int[] nums = {7, 10, 2, 6, 19, 22, 32};
        int len = nums.length;

        int[] righMin = new int[len];
        righMin[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            righMin[i] = Math.min(nums[i],righMin[i+1]);
        }
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (leftMax <= nums[i]) {
                leftMax = nums[i];
                if (nums[i] == righMin[i]) {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
