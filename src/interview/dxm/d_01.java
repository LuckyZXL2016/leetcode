package interview.dxm;

/**
 * 打印出 1000以内的质数个数
 * Created by ZXL on 2019/9/24.
 */
public class d_01 {
    public static void main(String[] args) {
        int sum = 2;
        for (int i = 4; i <= 1000; i++) {
            sum += isPrimeNum(i);
        }
        System.out.println(sum);
    }

    private static int isPrimeNum(int n) {
        int k = (int)Math.sqrt(n);
        int flag = 1;
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                flag = 0;
                break;
            }
        }
        return flag;
    }
}
