package leetCode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k个最大的元素。请注意，你需要找的是数组排序
 * 后的第 k个最大的元素，而不是第 k个不同的元素。
 * Created by ZXL on 2019/7/18.
 * <p>
 * 示例 :
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class array12 {

    // 方法一：排序
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k - 1];
    }

    // 方法二：堆
    // 创建一个小顶堆，用PriorityQueue实现最大最小堆：https://www.cnblogs.com/yongh/p/9945539.html
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
