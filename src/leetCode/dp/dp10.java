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

    // 购买两次股票
    private static int maxProfitTwice(int[] prices) {
        int len = prices.length;

        // [i][j] ,i j为当前到达第 i天时最多进行 j次交易
        // local[i][j] 表示 最好一次交易在第 i天卖出的利润
        // global[i][j] 表示 第 i天时最多进行 j次交易的最大利润
        int[][] local = new int[len + 1][3];
        int[][] global = new int[len + 1][3];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                // local中 local[i-1][j] + diff 也是只进行 j次交易
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        return global[len - 1][2];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 10};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
