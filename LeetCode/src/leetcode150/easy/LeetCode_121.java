package leetcode150.easy;

/**
 *
 * 买卖股票的最佳时机
 *
 * @author paksu
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class LeetCode_121 {

    /**
     * 计算最大利润，与买卖股票的最佳时机II不同的是，II是计算最大的累积利润
     * 1、记录 今天之前买入的最小值
     * 2、计算 在之前最小值买入的情况下，今天卖出的利润
     * 3、比较 之前所卖出的利润，获得最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
