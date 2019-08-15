package examination.pufa;

import java.util.Scanner;

/**
 * 输入十个数，最大数和最后一个数交换，最小数和第一个数交换
 * Created by ZXL on 2019/8/15.
 */
public class p_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }
        
        int max = 0, min = 0;
        for (int i = 1; i < 10; i++) {
            if (nums[i] > nums[max]) max = i;
            if (nums[i] < nums[min]) min = i;
        }

        int tmp;
        if (max == 0 && min == 9) {
            tmp = nums[9];
            nums[9] = nums[max];
            nums[max] = tmp;
        } else {
            tmp = nums[0];
            nums[0] = nums[min];
            nums[min] = tmp;

            tmp = nums[9];
            nums[9] = nums[max];
            nums[max] = tmp;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
