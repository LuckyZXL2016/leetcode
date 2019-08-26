package swordOffer.algorithms;

/**
 * 调整数组顺序使奇数位于偶数前面
 * Created by ZXL on 2019/8/26.
 */
public class a_02_reOrderArray {
    private static void reOrderArray(int[] array) {
        int len = array.length;
        // 奇数个数
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) num++;
        }
        int left = 0;
        int right = num;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {
                res[left++] = array[i];
            } else {
                res[right++] = array[i];
            }
        }
        for (int i = 0; i < len; i++) {
            array[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
