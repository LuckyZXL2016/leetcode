package leetCode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在
 * 四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有
 * 满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * Created by ZXL on 2019/3/25.
 * <p>
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class hash_02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int sum = target - nums[i] - nums[j];
                        int l = j + 1, r = n - 1;
                        while (l < r) {
                            if (nums[l] + nums[r] == sum) {
                                ls.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                l++;
                                r--;
                            } else if (nums[l] + nums[r] < sum) {
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                l++;
                            } else {
                                while (l < r && nums[r] == nums[r - 1]) r--;
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        hash_02 example = new hash_02();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(example.fourSum(nums, 0));
    }
}
