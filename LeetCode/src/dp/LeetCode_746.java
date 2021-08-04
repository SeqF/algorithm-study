package dp;

/**
 * 使用最小花费爬楼梯
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class LeetCode_746 {

    /**
     * 动态规划
     * 1、dp数组：dp[i]表示上到第i层阶梯，一共要花费dp[i]的体力
     * 2、递推公式：dp[i-1]爬1层到dp[i]、dp[i-2]爬2层到dp[2]，取最小的体力->dp[i]=min(dp[i-1]+dp[i-2])+cost[i]
     * 3、dp数组初始化：dp[0]=cost[0]、dp[1]=cost[1]
     * 4、遍历顺序：从前往后遍历
     * 5、举例推导dp数组：cost=[1,100,1,1,1,100,1,1,100,1]->dp=[1,100,2,3,3,103,4,5,104,6]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Integer.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Integer.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
