package examination.qushi;

import java.util.Scanner;

//有数量不限的面值为100，50，20，10，5，1元的纸币，问要组成N（N<=10^6）共有多少种组合方式？（Google笔试题）
public class q_01_coin {
    public static void main(String[] args) {

        System.out.println("Input the N: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Run1(n);  //当数据增大的时，Run1的时间花销比Run2 小（n>200后），小得多（n>500）,  n=1000 0.025s； n=2000  0.683s  ;n=3000  约5s
        Run2(n);  //n=1000约2.4s ；n=2000 约135s；   1的时间更少是因为递归调用的次数少很多次，公式里少，还少个循环
        Run3(n);  //爆搜法：  时间跟多， 因为考虑了所有情况  n=100为5ms；  n=200时134ms  ；n=500时 约19.8s
        //爆搜法，适当减少循环内容，时间是和没优化的冬天规划方法时间差不多的
    }

//	n=1500时
//	17132256 : 168ms
//	17132256 : 22945ms
//	17132256 : 23124ms

    private static void Run3(int n) {
        long start = System.currentTimeMillis();
        int[] k = {100, 50, 20, 10, 5, 1};
        int m = Calculate3(n, k);
        long end = System.currentTimeMillis();
        System.out.println(m + " : " + (end - start) + "ms");

    }

    private static int Calculate3(int n, int[] k) {
        int count = 0;
        int[] kc = {n / 100, n / 50, n / 20, n / 10, n / 5, n};
        for (int i1 = 0; i1 <= n / 100; i1++) {
            for (int i2 = 0; i2 <= (n - i1 * 100) / 50; i2++) {
                for (int i3 = 0; i3 <= (n - i1 * 100 - i2 * 50) / 20; i3++) {
                    for (int i4 = 0; i4 <= (n - i1 * 100 - i2 * 50 - i3 * 20) / 10; i4++) {
                        for (int i5 = 0; i5 <= (n - i1 * 100 - i2 * 50 - i3 * 20 - i4 * 10) / 5; i5++) {
                            for (int i6 = 0; i6 <= n - i1 * 100 - i2 * 50 - i3 * 20 - i4 * 10 - i5 * 5; i6++) {
                                if (i1 * 100 + i2 * 50 + i3 * 20 + i4 * 10 + i5 * 5 + i6 == n)
                                    count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static void Run1(int n) {   //动态规划1
        long start = System.currentTimeMillis();
        int[] k = {100, 50, 20, 10, 5, 1};   // 这种创建并同时赋予初值的简化形式 的语句，是不需要调用new的！；
        int m = Calculate1(n, k, 0);
        long end = System.currentTimeMillis();
        System.out.println(m + " : " + (end - start) + "ms");
    }

    private static int Calculate1(int n, int[] k, int i) {
//		c[n][k]表示组成 N=n、最大面额的纸币为k (不一定要有k)的组合数据量
//		c[n-k][k] 表示组成 N=n、最大币值为k， 且最少含有一个k值的纸币 的组合的数量
//		用于动态规划的 通项公式 :   c[n][k(i)]=c[n-k(i)][k(i)]+c[n][k(i+1)], 即：
//		c[n][100]=c[n-100][100]+c[n][50];
//		c[n][50]=c[n-50][50]+c[n][20]
//		c[n][20]=c[n-20][20]+c[n][10]
//		c[n][10]=c[n-10][10]+c[n][5]
//	    c[n][5]=c[n-5][5]+c[n][1]
//	    c[n][1]=c[n-1][1]=1;
//		初至： 当n=0时 c[n][k]=1;   当n<0时   c[n][k]=0;  当k(i)=1时 c[n][k]=1; k的取值为{100、50、20、10、5、1}
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (i == 5)
            return 1;
        else
            return Calculate1(n - k[i], k, i) + Calculate1(n, k, i + 1);   // 时间复杂度为O(n)
    }

    private static void Run2(int n) {   //动态规划2

//		设d[n][k]表示面值为n、最大面额的纸币为k的组合数据量; 这里值k 至少有一个
//		通项为：f(n)=d[n][100]+d[n][50]+d[n][20]+d[n][10]+d[n][5]+d[n][1]   f(n) 表示最大面额为k ，但不一定有k的 组合个数

        long start = System.currentTimeMillis();
        int[] k = {100, 50, 20, 10, 5, 1};   // 这种创建并同时赋予初值的简化形式 的语句，是不需要调用new的！；
        int m = 0;
        for (int i = 0; i < k.length; i++) {
            m += Calculate2(n, k, i);
        }
        long end = System.currentTimeMillis();
        System.out.println(m + " : " + (end - start) + "ms");
    }

    private static int Calculate2(int n, int[] k, int i) {
//		设d[n][k]表示面值为n、最大面额的纸币为k的组合数据量; 这里值k 至少有一个
//		通项为：f(n)=d[n][100]+d[n][50]+d[n][20]+d[n][10]+d[n][5]+d[n][1]   f(n) 表示最大面额为k ，但不一定有k的 组合个数
//		且: d[n][100]=d[n-100][100]+d[n-100][50]+d[n-100][20]+d[n-100][10]+d[n-100][5]+d[n-100][1];
//		初值：  当n<=0时d[n][k]=0;   当n=k时 d[n][k]=1;

//		d[n][100] = d[n-100][100]+d[n-100][50]+d[n-100][20]+d[n-100][10]+d[n-100][5]+d[n-100][1];
//		d[n][50] = d[n-50][50]+d[n-50][20]+d[n-50][10]+d[n-50][5]+d[n-50][1];
//		d[n][20] = d[n-20][20]+d[n-20][10]+d[n-20][5]+d[n-20][1];
//		d[n][10] = d[n-10][10]+d[n-10][5]+d[n-10][1];
//		d[n][5] = d[n-5][5]+d[n-5][1];
//		d[n][1] = d[n-1][1];
//		d[1][1]=d[5][5]=d[10][10]=d[20][20]=d[50][50]=d[100][100]=1;
//		最后f（n）=d[n][100]+d[n][50]+d[n][20]+d[n][10]+d[n][5]+d[n][1];

        if (n < k[i])
            return 0;
        if (n == k[i])
            return 1;
//		if(k[i]==1)
//			return 1;
        else {
            int m = 0;
            for (int j = i; j < k.length; j++) {
                m += Calculate2(n - k[i], k, j);
            }
            return m;
        }

    }
}
