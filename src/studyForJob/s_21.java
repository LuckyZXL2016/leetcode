package studyForJob;

/**
 * 逆序数对
 * Created by ZXL on 2019/8/30.
 */
public class s_21 {
    public int inversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0, end = nums.length - 1;
        int count = getCount(nums, start, end);
        return count;
    }

    private int getCount(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        int leftCount = getCount(nums, start, middle);
        int rightCount = getCount(nums, middle + 1, end);

        int count = 0;
        int i = middle, j = end, k = end;
        int[] tmp = new int[nums.length];
        while (i >= start && j >= middle + 1) {
            if (nums[i] > nums[j]) {
                count = count + (j - middle);
                tmp[k--] = nums[i--];
            } else {
                tmp[k--] = nums[j--];
            }
        }
        while (i >= start) tmp[k--] = nums[i--];
        while (j >= middle + 1) tmp[k--] = nums[j--];

        for (int l = start; l <= end; l++) {
            nums[l] = tmp[l];
        }

        return count + leftCount + rightCount;
    }
}
