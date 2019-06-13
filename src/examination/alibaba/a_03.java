package examination.alibaba;

/**
 * 阶乘相关的三个题目
 * Created by ZXL on 2019/4/9.
 */
// 参考网址：https://blog.51cto.com/13754022/2365360
public class a_03 {
    // 给定一个整数N，那么N的阶乘N!末尾有多少个0？例如：N=10，则N！=3628800，那么N!的末尾有两个0。
    // 每有一个5相乘后有一个0
    public static int getZeroSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                sum++;
                j = j / 5;
            }
        }
        return sum;
    }

    // 优雅写法
    public static int getZeroSum2(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }

    // 求N!的二进制表示中最低位1的位置。例如3！=6，二进制为1010，所以最低位1的位置在第二位。
    // 每相乘一个2则左移一位
    public static int getOnePlace(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n / 2;
            n = n / 2;
        }
        return sum;
    }

    // 优化代码
    public static int getOnePlace2(int n) {
        int sum = 0;
        while (n != 0) {
            n >>= 1;
            sum += n;
        }
        return sum;
    }

    // 给你一个数N，输出N!的值。N的范围不限定。
    // 两个大整数相乘
    public static String getNF(int n) {
        String s = "1";
        Integer t = null;
        for (int i = 2; i <= n; i++) {
            t = i;
            s = mul(s, t.toString());
        }
        return s;
    }

    // 大整数相乘
    public static String mul(String s1, String s2) {
        // 先把字符串转化为 字符数组
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length + c2.length;
        // 用来存放两个数的积，字符的初始值为 '\u0000'，也就是 0
        char[] c = new char[len];
        // 由于大整数的低位是在字符串的末尾，所以我们从末尾遍历来计算
        for (int i = c1.length - 1; i >= 0; i--) {
            int index = len - 1;
            int res = 0;    // 用来存放进位
            for (int j = c2.length - 1; j >= 0; j--) {
                int temp = (c1[i] - '0') * (c2[j] - '0') + c[index] + res;
                res = temp / 10;
                c[index--] = (char) (temp % 10);
            }
            // 每趟乘下来的进位要进行保存
            c[index] = (char) res;
            len--;
        }
        // 最后把c中的字符加上'0'
        for (int i = 0; i < c.length; i++) {
            c[i] += '0';
        }
        String s = new String(c);
        // n位数乘以m位数得到积位 (m+n)位数或者(n+m-1)位数
        // 我们只需要判断c[0]是否为0，为0则把它舍弃。
        if (c[0] == '0') {
            return s.substring(1);
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(getZeroSum(100));
        System.out.println(getZeroSum2(100));
        System.out.println(getOnePlace(8));
        System.out.println(getOnePlace2(8));
        System.out.println(getNF(5));
        System.out.println(mul("2", "3"));
    }
}
