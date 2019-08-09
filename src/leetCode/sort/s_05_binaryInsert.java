package leetCode.sort;

/**
 * 折半插入排序算法
 * Created by ZXL on 2019/8/9.
 */
public class s_05_binaryInsert {
    private static void binaryInsert(int[] a) {
        int len = a.length;
        int i, j;
        for (i = 1; i < len; i++) {
            int tmp = a[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a[mid] > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j >= low; j--) {
                a[j + 1] = a[j];
            }
            a[low] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9};
        binaryInsert(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
