package leetCode.sort;

/**
 * 冒泡排序
 * Created by ZXL on 2019/8/5.
 */
public class s_03_bubble {

    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
        bubbleSort(a);
    }

    private static void bubbleSort(int[] a) {
        int len = a.length;
        int temp = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        toString(a);
    }

    private static void toString(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
