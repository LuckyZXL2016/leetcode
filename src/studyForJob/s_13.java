package studyForJob;

/**
 * 二维数组，左到右递增，上到下递增
 * 查找一个数是否在二维数组中
 * Created by ZXL on 2019/8/29.
 */
public class s_13 {
    private static boolean find(int[][] nums, int target) {
        int row = 0;
        int col = nums[0].length - 1;
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return true;
            } else if (nums[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(find(nums, 5));
        System.out.println(find(nums, 10));
    }
}
