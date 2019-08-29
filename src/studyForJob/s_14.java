package studyForJob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个乱序数组，找到所有三个数集合，使得 a+b+c=0
 * Created by ZXL on 2019/8/29.
 */
public class s_14 {
    // 不重复
    private static List<List<Integer>> getThreeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            int sum = target - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    // 重复
    private static List<List<Integer>> getThreeSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = len - 1;
                int sum = target - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
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
        return res;
    }

    private static void printList(List<List<Integer>> res) {
        for (List<Integer> l : res) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 7, 2, 2, 3, 3, 5, 9, 11, 12};
        List<List<Integer>> res = getThreeSum(nums, 11);
        List<List<Integer>> res2 = getThreeSum2(nums, 11);

        printList(res);
        System.out.println();
        System.out.println("==========");
        printList(res2);
    }
}
