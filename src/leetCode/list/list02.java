package leetCode.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * Created by ZXL on 2019/6/14.
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class list02 {
    private static void backtrack(int n,
                                  ArrayList<Integer> nums,
                                  List<List<Integer>> output,
                                  int first) {
        if (first == n) {
            output.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> nums_ls = new ArrayList<>();
        for (int num : nums) {
            nums_ls.add(num);
        }
        int len = nums.length;
        backtrack(len, nums_ls, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
