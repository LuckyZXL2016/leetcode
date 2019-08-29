package studyForJob;

/**
 * 归并排序
 * Created by ZXL on 2019/8/29.
 */
public class s_09 {
    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            mergeArray(nums, start, middle, end);
        }
    }

    private static void mergeArray(int[] nums, int start, int middle, int end) {
        int p = start, q = middle + 1;
        int index = start;
        int[] res = new int[nums.length];
        while (p <= middle && q <= end) {
            if (nums[p] <= nums[q]) {
                res[index++] = nums[p++];
            } else {
                res[index++] = nums[q++];
            }
        }
        while (p <= middle) res[index++] = nums[p++];
        while (q <= end) res[index++] = nums[q++];

        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 8, 3, 9, 10, 2};
        int len = nums.length;
        mergeSort(nums, 0, len - 1);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
