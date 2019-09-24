package interview.futu;

/**
 * 求个人所得税的程序题。
 * Created by ZXL on 2019/9/24.
 *
 * 编写一个程序计算个人所得税(基础工资3500)，要求输入金额后能够输出应缴的个人所得税，个人所得税计算办法如下：
 *  起征点为1500(工资 - 3500)
 *  不超过1500元的部分，征收3%
 *  超过1500~4500元的部分，征收10%
 *  超过4500~9000元的部分，征收20%
 *  超过9000~35000元的部分，征收25%
 *  超过35000~55000元的部分，征收30%
 *  超过55000~80000元的部分，征收35%
 *  超过80000元以上的部分，征收45%
 */
public class f_03 {
    public static void main(String[] args) {
        double salary = 100000;
        double taxsal = salary - 3500;
        // 变量保存结果
        double culsal = 0;

        if (taxsal <= 0) {
            culsal = 0;
        } else if (taxsal <= 1500) {
            culsal = taxsal * 0.03f;
        } else if (taxsal <= 4500) {
            culsal = 1500 * 0.03f + (taxsal - 1500) * 0.10f;
        } else if (taxsal <= 9000) {
            culsal = 1500 * 0.03f + 3000 * 0.10f + (taxsal - 4500) * 0.20f;
        } else if (taxsal <= 35000) {
            culsal = 1500 * 0.03f + 3000 * 0.10f + 4500 * 0.20f + (taxsal - 9000) * 0.25f;
        } else if (taxsal <= 55000) {
            culsal = 1500 * 0.03f + 3000 * 0.10f + 4500 * 0.20f + 26000 * 0.25f + (taxsal - 35000) * 0.30f;
        } else if (taxsal <= 80000) {
            culsal = 1500 * 0.03f + 3000 * 0.10f + 4500 * 0.20f + 26000 * 0.25f + 20000 * 0.30f + (taxsal - 55000) * 0.35f;
        } else {
            culsal = 1500 * 0.03f + 3000 * 0.10f + 4500 * 0.20f + 26000 * 0.25f + 20000 * 0.30f + 25000 * 0.35f + (taxsal - 80000) * 0.45f;
        }
        System.out.println(culsal);
    }
}
