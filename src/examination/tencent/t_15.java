package examination.tencent;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * Created by ZXL on 2019/6/11.
 */
public class t_15 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        } else {
            int temp = x;
            int m, num = 0;
            while (temp != 0) {
                m = temp % 10;
                num = num * 10 + m;
                temp = temp / 10;
            }
            if (num == x) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
    }
}
