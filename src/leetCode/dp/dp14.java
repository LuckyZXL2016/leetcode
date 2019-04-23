package leetCode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都
 * 围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防
 * 盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * Created by ZXL on 2019/4/23.
 * <p>
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class dp14 {
    public static int getMaxSum(int i, int j, int[] nums) {
        int n = nums.length;
        int[] memo = new int[n - 1];
        memo[0] = nums[i];
        memo[1] = Math.max(memo[0], nums[i + 1]);
        for (int m = i + 2, k = 2; m <= j; m++, k++) {
            memo[k] = Math.max(memo[k - 2] + nums[m], memo[k - 1]);
        }
        return memo[n - 2];
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        return Math.max(getMaxSum(0, n - 2, nums), getMaxSum(1, n - 1, nums));
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {0, 0};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
    }
}
