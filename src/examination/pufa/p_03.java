package examination.pufa;

import java.util.Scanner;

/**
 * 每次只能爬一个或者两个台阶，输入 1 <= n < 90 的数字为台阶数，
 * 以输入 0 作为结束标志，输出n个台阶共有多少种上楼方式.
 * Created by ZXL on 2019/8/15.
 * <p>
 * 输入
 * 1
 * 2
 * 3
 * 4
 * 0
 * 输出
 * 1
 * 2
 * 3
 * 5
 */
public class p_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step;
        int[] nums = new int[1000];
        int count = 0;
        while ((step = sc.nextInt()) != 0) {
            int tmp = getNum(step);
            nums[count] = tmp;
            count++;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int getNum(int step) {
        if (step <= 2) {
            return step;
        } else {
            return getNum(step - 1) + getNum(step - 2);
        }
    }
}
