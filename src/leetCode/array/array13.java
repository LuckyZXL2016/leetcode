package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 * Created by ZXL on 2019/7/18.
 *
 * 示例 :
 *  输入: [1,2,3,1]
 *  输出: true
 */
public class array13 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], -1);
            if (value == -1) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
