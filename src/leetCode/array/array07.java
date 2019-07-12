package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * Created by ZXL on 2019/7/12.
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class array07 {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int i = 0; i < len; i++) {
            List<List<Integer>> ans_temp = new ArrayList<>();

            for (List<Integer> list : ans) {
                List<Integer> ls = new ArrayList<>(list);
                ls.add(nums[i]);
                ans_temp.add(ls);
            }
            ans.addAll(ans_temp);
        }
        return ans;
    }
}
