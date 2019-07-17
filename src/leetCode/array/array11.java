package leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为n的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊n/2⌋的元素。
 * 假设数组是非空的，并且给定的数组总是存在众数。
 * Created by ZXL on 2019/7/17.
 */
public class array11 {

    // 方法一：哈希表
    public int majorityElement1(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(nums[i]);
            if (n == null) {
                map.put(nums[i], 1);
            } else {
                ++n;
                map.put(nums[i], n);
                if (n > (nums.length / 2)) return nums[i];
            }
        }
        return -1;
    }

    // 方法二：排序
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 方法三：分治
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int majorityElementRec(int[] nums, int l, int h) {
        if (l == h) {
            return nums[l];
        }

        int mid = (h - l) / 2 + l;
        int left = majorityElementRec(nums, l, mid);
        int right = majorityElementRec(nums, mid + 1, h);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, l, h);
        int rightCount = countInRange(nums, right, l, h);

        return leftCount > rightCount ? left : left;
    }

    public int countInRange(int[] nums, int num, int l, int h) {
        int count = 0;
        for (int i = l; i <= h; i++) {
            if (nums[i] == num) {
                ++count;
            }
        }
        return count;
    }
}
