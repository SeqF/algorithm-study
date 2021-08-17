package dp;

import java.util.Arrays;

/**
 * 背包问题
 *
 * @author paksu
 */
public class KnapsackProblem {

    /**
     * 01背包问题，每个物品只能用一次
     * 1、确定dp[i][j]的含义：dp[i][j]表示从下标为[0,i]的物品里面任意取，放进容量为j的背包里，最大的价值总和
     * 2、确定递推公式：分为两种情况-> (1)不放i ：由dp[i-1][j]推出，即选择i-1号物品，且背包容量为j（没把i放入）时的价值
     *                             (2)放i ：由dp[i-1][j-weight[i]]为没放i物品，且容量为j-weight[i]的价值，那么就加上当前物品的价值 dp[i-1][j-weight[i]]+value[i]
     *                           -> 状态转移方程：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
     * 3、dp数组初始化：(1) 当j为0(即背包容量为0的时候),dp[i][0]=0（不管放哪个物品都不够放）
     *                (2) 根据状态转移方程，i是由i-1推导出来，所以要对i=0时进行初始化，即dp[0][j]->当weight[0]<j,能放入背包，dp[0][j]=value[0];当weight[0]>j时，不能放入，dp[0][j]=0
     *                (3) 其他下标都是从左上方数值推导出来，所以任意初始化即可，一般初始化为0
     * 4、确定遍历顺序：一种是先遍历物品，再遍历背包；一种是先遍历背包，再遍历物品。先后顺序是有讲究的，01背包的情况下，无论哪种都可以
     */
    private void knapsackProblem01() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;

        int weightLength = weight.length;
        int zeroValue = 0;
        //定义dp数组：dp[i][j]为选择i号物品，背包容量为j时的最大价值
        int[][] dp = new int[weightLength][bagSize + 1];
        //初始化：背包容量为0时，最大价值都为0
        for (int i = 0; i < weightLength; i++) {
            dp[i][0] = zeroValue;
        }
        //对i=0的初始化,weight[0]>背包容量，不能放入
//        for (int j = 0; j < weight[0]; j++) {
//            dp[0][j] = 0;
//        }
        //对i=0的初始化,weight[0]<背包容量，能放入
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i < weightLength; i++) {
            for (int j = 0; j <=bagSize; j++) {
                //不放入
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    public static void main(String[] args) {
        KnapsackProblem problem = new KnapsackProblem();
        problem.knapsackProblem01();
    }
}
