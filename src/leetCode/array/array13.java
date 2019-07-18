package leetCode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    // 第一种方法
    public boolean containsDuplicate1(int[] nums) {
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

    // 第二种方法
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) return false;

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num: nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
