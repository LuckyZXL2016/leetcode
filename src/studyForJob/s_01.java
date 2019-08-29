package studyForJob;

/**
 * 旋转排序数组中的中位数
 * Created by ZXL on 2019/8/29.
 */
public class s_01 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {4, 5, 6, 7, 1, 2, 3};

        int res1 = getMedian(nums1);
        int res2 = getMedian(nums2);

        System.out.println(res1 + " " + res2);
    }

    private static int getMedian(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return nums[(len - 1) / 2];
        }

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (nums[middle] > nums[r]) {
                l = middle + 1;
            } else if (nums[middle] < nums[l]) {
                r = middle;
            } else {
                r--;
            }
        }
        return nums[(l + (len - 1) / 2) % len];
    }
}
