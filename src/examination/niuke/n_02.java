package examination.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【得分最大】
 * 牛牛和妞妞从他们的好朋友果果处得到了两个盒子，盒子里是一些写了分值的彩球。牛牛和妞妞
 * 发现两个盒子里的彩球数目是相等的，就决定一人一个。妞妞拿到自己的盒子之后，决定跟牛牛
 * 玩一个游戏，规则如下：
 * 一开始两个人盒子里的彩球数目都是n个，由妞妞先手，两人轮流实行下面两个操作中的一个（只
 * 能选其中一个执行，不能不执行。），直到两个盒子里的彩球都被拿完位置。
 * 1、从自己的盒子里选一个球拿出来，把球上面的分值加在自己的总得分上边。
 * 2、从对方的盒子里选一个球拿出来，把这个球移出游戏（对方不能再拿这个球）。
 * 妞妞和牛牛都十分聪明，不会出错，并且尽可能让自己的得分比对方多。妞妞想知道，在游戏结
 * 束的时候，他能比牛牛多得多少分呢？
 * 输入描述：
 * 第一行一个数字n，表示盒子里初始彩球的数目。
 * 第二行n个数字a ，表示妞妞盒子里第i个彩球的分值是a。
 * 第三行n个数字b ，表示牛牛盒子里第i个彩球的分值是b。
 * 输出描述：
 * 一个整数ans，表示游戏结束的时候妞妞比牛牛多的分值。
 * Created by ZXL on 2019/3/20.
 * <p>
 * 示例1：
 * 输入
 * 3
 * 2 7 7
 * 2 8 7
 * 输出
 * 0
 */
public class n_02 {
    /**
     * 双方都要使自己的得分尽可能比对方多，就有两种策略：使自己得分越多越好；使对方得分越少越好。所以贪心
     * 比较当前自己盒子里分值最大的彩球和对方盒子里分值最大的彩球，如果自己的分比较多，就从自己盒子里拿（自
     * 己得分越多越好），否则从对方盒子里拿（对方得分越少越好）。
     */

    public int[] arrayReverse(int[] array, int n) {
        int temp = 0;
        for (int i = 0; i < n / 2; i++) {
            temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        return array;
    }

    public int getValue(int[] a, int[] b, int m) {
        Arrays.sort(a, 0, m);
        a = arrayReverse(a, m);
        Arrays.sort(b, 0, m);
        b = arrayReverse(b, m);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < m || j < m) {
            if (a[i] >= b[j]) {
                ans += a[i];
                i++;
            } else {
                j++;
            }
            if (b[j] >= a[i]) {
                ans -= b[j];
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        n_02 example = new n_02();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m;
        int[] a = new int[100015];
        int[] b = new int[100015];
        int i = 0;
        int j = 0;
        while (n-- != 0) {
            a[i] = sc.nextInt();
            i++;
        }
        n = m;
        while (n-- != 0) {
            b[j] = sc.nextInt();
            j++;
        }
        System.out.println(example.getValue(a, b, m));
    }
}
