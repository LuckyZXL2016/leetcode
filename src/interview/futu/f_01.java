package interview.futu;

import java.util.Random;

/**
 * 求A数组是否在B数组中
 * Created by ZXL on 2019/9/24.
 */
public class f_01 {
    public static void main(String[] args) {
        int[] nums1 = {11, 22, 33, 56, 16, 18, 66};
        int[] nums2 = {33, 11, 88, 22, 33, 56, 16, 44, 99, 18, 66};
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);
        boolean flag = isSubset(nums2,nums1);
        System.out.println(flag);
    }

    private static boolean isSubset(int[] arr1,int[] arr2) {
        int i=0,j=0;
        if (arr1.length < arr2.length) return false;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        if (j < arr2.length) {
            return false;
        } else {
            return true;
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    private static int getIndex(int[] nums, int low, int high) {
        Random in = new Random();
        int index = in.nextInt(high - low + 1) + low;
        int tmp = nums[index];
        while (low < high) {
            while (index < high && nums[high] >= tmp) {
                high--;
            }
            if (index < high) {
                nums[index] = nums[high];
                index = high;
            }
            while (index > low && nums[low] <= tmp) {
                low++;
            }
            if (index > low) {
                nums[index] = nums[low];
                index = low;
            }
        }
        nums[index] = tmp;
        return index;
    }

    private static int getIndex2(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= tmp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= tmp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }
}
