package leetCode.other;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * Created by ZXL on 2019/7/19.
 * <p>
 * 示例 :
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 */
public class ot01 {

    // 方法一：循环
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        while (n != 1) {
            int tmp = n / 2;
            if (tmp * 2 != n) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    // 方法二：二进制
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
