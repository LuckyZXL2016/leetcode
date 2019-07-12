package leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：算法应该具有线性时间复杂度。不使用额外空间
 * Created by ZXL on 2019/7/12.
 */
public class array10 {

    // 解法一，异或
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return -1;
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    // 解法二，hash
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int num : nums) {
            Integer count = ans.get(num);
            count = count == null ? 1 : ++count;
            ans.put(num, count);
        }

        for (int num:ans.keySet()) {
            Integer count = ans.get(num);
            if (count == 1) {
                return num;
            }
        }
        return -1;
    }
}
