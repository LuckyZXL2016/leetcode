package studyForJob;

/**
 * 快速排序
 * Created by ZXL on 2019/8/29.
 */
public class s_08 {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 14, 15, 19, 20};

        int len = nums.length;
        partition(nums, 0, len - 1);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void partition(int[] nums, int low, int high) {
        int index = getIndex(nums, low, high);
        if (index > low) {
            partition(nums, low, index - 1);
        }
        if (index < high) {
            partition(nums, index + 1, high);
        }
    }

    private static int getIndex(int[] nums, int low, int high) {
        int tmp = nums[low];

        while (low < high) {
            while (low < high && nums[high] > tmp) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] < tmp) low++;
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }
}
