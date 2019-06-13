package leetCode.array;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 可以假设数组中不存在重复的元素。
 * 算法时间复杂度必须是 O(log n) 级别。
 * Created by ZXL on 2019/6/12.
 */
public class array05 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int len = nums.length;
        int index = find_rotate_index(nums);
        if (nums[index] == target) {
            return index;
        }
        if (index == 0) {
            return search(nums, target, index, len - 1);
        }
        if (target < nums[0]) {
            return search(nums, target, index, len - 1);
        }
        return search(nums, target, 0, index - 1);
    }

    private static int find_rotate_index(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        int len = nums.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                if (nums[mid] > nums[start]) {
                    start = mid + 1;
                } else {
                    end = end - 1;
                }
            }
        }
        return 0;
    }

    private static int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
