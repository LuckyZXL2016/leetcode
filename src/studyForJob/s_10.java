package studyForJob;

/**
 * 堆排序
 * Created by ZXL on 2019/8/29.
 */
public class s_10 {
    private static void adjustHeapSort(int[] nums, int i, int len) {
        int tmp = nums[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if ((k + 1) < len && nums[k + 1] > nums[k]) {
                k++;
            }
            if (nums[i] < nums[k]) {
                nums[i] = nums[k];

                i = k;
            }
        }
        nums[i] = tmp;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 7, 6, 10, 8, 5, 9};
        int len = nums.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeapSort(nums, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            adjustHeapSort(nums, 0, i);
        }

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
