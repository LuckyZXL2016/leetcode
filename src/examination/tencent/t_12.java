package examination.tencent;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * Created by ZXL on 2019/6/10.
 */
public class t_12 {
    // 该方法不能满足时间条件
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] res = new int[len1 + len2];
        double value = 0;
        // arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
        // src:源数组；srcPos:源数组要复制的起始位置；dest:目的数组；destPos:目的数组放置的起始位置；
        // length:复制的长度。注意：src and dest都必须是同类型或者可以进行转换类型的数组．
        System.arraycopy(nums1, 0, res, 0, len1);
        System.arraycopy(nums2, 0, res, len1, len2);
        Arrays.sort(res);
        if (len % 2 == 0) {
            double sum = res[(len - 1) / 2] + res[len / 2];
            value = sum / 2;
        } else {
            value = res[(len - 1) / 2];
        }
        return value;
    }

    // 第二种方法
    // 参考网址：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/4-xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu/
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        // Ci 为第i个数组的割,比如C1为2时表示第1个数组只有2个元素。LMaxi为第i个数组割后的左元素。
        // RMini为第i个数组割后的右元素。
        int LMax1 = 0, LMax2=0, RMin1=0, RMin2=0;
        int c1, c2, l0 = 0, hi = 2 * len1;
        while (l0 <= hi) {
            c1 = (l0 + hi) / 2;
            c2 = len1 + len2 - c1;

            LMax1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            RMin1 = (c1 == 2 * len1) ? Integer.MAX_VALUE : nums1[c1 / 2];
            LMax2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            RMin2 = (c2 == 2 * len2) ? Integer.MAX_VALUE : nums2[c2 / 2];

            if(LMax1 > RMin2) {
                hi = c1 - 1;
            } else if (LMax2 > RMin1) {
                l0 = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2)) / 2.0;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums3, nums4));
    }
}
