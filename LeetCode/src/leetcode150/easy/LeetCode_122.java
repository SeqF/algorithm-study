package leetcode150.easy;

/**
 * 买卖股票的最佳时机 II
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class LeetCode_122 {

    /**
     * 当天卖出的股票，当天还能买入，所以利润是每天叠加
     * 相当于涨价，在一定时间内的涨价相当于每天的涨幅加起来之和，不用管是在第几天进行购买和抛售
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
