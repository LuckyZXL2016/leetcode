package examination.tencent;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和
 * 与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * Created by ZXL on 2019/6/11.
 */
public class t_17 {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                } else if (ans < sum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
