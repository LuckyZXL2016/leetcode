package examination.byteDance;

/**
 * 旋转排序数组的中位数
 * Created by ZXL on 2019/8/15.
 */
public class b_04 {
    public static int findMedian(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return nums[(len - 1) / 2];
        }

        int start = 0 , end = len - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] > nums[end]) {
                start = middle+1;
            } else if (nums[middle] < nums[start]) {
                end = middle;
            } else {
                end--;
            }
        }
        return nums[(start + len / 2) % len];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMedian(nums));
    }
}
