package leetCode.sort;

/**
 * 归并排序
 * Created by ZXL on 2019/8/5.
 */
public class s_04_merge {
    // 两路归并算法，两个排好序的子序列合并为一个子序列
    private static void merge(int[] a, int left, int mid, int right) {
        // 辅助数组
        int[] tmp = new int[a.length];
        // p1,p2是检测指针，k是存放指针
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }
        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];

        for (int i = left; i <= right; i++) {
            a[i] = tmp[i];
        }
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }
}
