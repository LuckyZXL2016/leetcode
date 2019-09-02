package leetCode.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计
 * 一个算法来计算你所能获取的最大利润。
 * Created by ZXL on 2019/3/12.
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
public class dp10 {
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (maxProfit < (prices[i] - minPrice)) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    private static int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];

        dp[0] = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < dp[i - 1]) {
                dp[i] = prices[i];
            } else {
                dp[i] = dp[i - 1];
            }
            max = Math.max(max, prices[i] - dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 10};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
