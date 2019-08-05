package examination.other;

import java.util.Scanner;

/**
 * Created by ZXL on 2019/8/3.
 */
public class o_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] array = new int[m][n];

        System.out.println(getMaxStep(array, k));
    }

    private static int getMaxStep(int[][] array, int k) {

        return 0;
    }
}
