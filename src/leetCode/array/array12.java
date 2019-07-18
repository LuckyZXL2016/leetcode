package leetCode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

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
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    // 方法三：快速选择
    int[] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;

    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];

        swap(pivot_index, right);
        int store_index = left;

        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        swap(store_index, right);
        return store_index;
    }

    // 返回第 k小的元素
    public int quickselect(int left, int right, int k_smallest) {
        if (left == right) return this.nums[left];

        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        pivot_index = partition(left, right, pivot_index);

        // pivot是 (N-k)小的位置
        if (k_smallest == pivot_index) {
            return this.nums[k_smallest];
        } else if (k_smallest < pivot_index) {
            return quickselect(left, pivot_index - 1, k_smallest);
        } else {
            return quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // 找到第(N - k)小的值
        return quickselect(0, size - 1, size - k);
    }
}
