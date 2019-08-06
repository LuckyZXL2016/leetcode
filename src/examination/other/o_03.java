package examination.other;

import java.util.Scanner;

/**
 * 股票问题
 * Created by ZXL on 2019/8/6.
 */
public class o_03 {
    public static int calMax(int[] prices) {
        int proFirBuy = Integer.MIN_VALUE, proFirSell = 0;
        int proSecBuy = Integer.MIN_VALUE, proSecSell = 0;

        for (int curPrice : prices) {

            proFirBuy = Math.max(proFirBuy, -curPrice);
            proFirSell = Math.max(proFirSell, curPrice + proFirBuy);

            proSecBuy = Math.max(proSecBuy, -curPrice + proFirSell);
            proSecSell = Math.max(proSecSell, curPrice + proSecBuy);
        }
        return proSecSell;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(calMax(prices));
    }
}
