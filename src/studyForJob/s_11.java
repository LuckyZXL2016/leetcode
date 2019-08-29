package studyForJob;

/**
 * 折半插入
 * Created by ZXL on 2019/8/29.
 */
public class s_11 {
    private static void binarySort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            int low = 0, high = i - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (tmp < nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                nums[j + 1] = nums[j];
            }
            nums[low] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 9, 8, 7, 5};
        binarySort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
