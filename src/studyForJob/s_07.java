package studyForJob;

/**
 * 冒泡排序
 * Created by ZXL on 2019/8/29.
 */
public class s_07 {
    private static void bubbleSort(int[] array) {
        int len = array.length;

        int tmp = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
