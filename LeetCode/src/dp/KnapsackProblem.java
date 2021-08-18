package dp;

import java.util.Arrays;

/**
 * 背包问题
 *
 * @author paksu
 */
public class KnapsackProblem {

    private static final int[] WEIGHT = {1, 3, 4};
    private static final int[] VALUE = {15, 20, 30};
    private static final int BAG_SIZE = 4;

    /**
     * 01背包问题，每个物品只能用一次
     * 1、确定dp[i][j]的含义：dp[i][j]表示从下标为[0,i]的物品里面任意取，放进容量为j的背包里，最大的价值总和
     * 2、确定递推公式：分为两种情况-> (1)不放i ：由dp[i-1][j]推出，即选择i-1号物品，且背包容量为j（没把i放入）时的价值
     *                             (2)放i ：由dp[i-1][j-weight[i]]为没放i物品，且容量为j-weight[i]的价值，那么就加上当前物品的价值 dp[i-1][j-weight[i]]+val[i]
     *                           -> 状态转移方程：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+val[i])
     * 3、dp数组初始化：(1) 当j为0(即背包容量为0的时候),dp[i][0]=0（不管放哪个物品都不够放）
     *                (2) 根据状态转移方程，i是由i-1推导出来，所以要对i=0时进行初始化，即dp[0][j]->当weight[0]<j,能放入背包，dp[0][j]=val[0];当weight[0]>j时，不能放入，dp[0][j]=0
     *                (3) 其他下标都是从左上方数值推导出来，所以任意初始化即可，一般初始化为0
     * 4、确定遍历顺序：一种是先遍历物品，再遍历背包；一种是先遍历背包，再遍历物品。先后顺序是有讲究的，01背包的情况下，无论哪种都可以
     */
    private void knapsackProblem01() {
        int weightLength = WEIGHT.length;
        int zeroValue = 0;
        //定义dp数组：dp[i][j]为选择i号物品，背包容量为j时的最大价值
        int[][] dp = new int[weightLength][BAG_SIZE + 1];
        //初始化：背包容量为0时，最大价值都为0
        for (int i = 0; i < weightLength; i++) {
            dp[i][0] = zeroValue;
        }
        //对i=0的初始化,weight[0]>背包容量，不能放入
//        for (int j = 0; j < weight[0]; j++) {
//            dp[0][j] = 0;
//        }
        //对i=0的初始化,weight[0]<背包容量，能放入
        for (int j = WEIGHT[0]; j <= BAG_SIZE; j++) {
            dp[0][j] = VALUE[0];
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i < weightLength; i++) {
            for (int j = 0; j <=BAG_SIZE; j++) {
                //不放入
                if (j < WEIGHT[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - WEIGHT[i]] + VALUE[i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    /**
     * 用一维数组来实现，即用dp[j]来代替dp[i][j]
     * 1、确定dp[j]的含义：dp[j]表示背包容量为j时的最大价值
     * 2、确定递推公式：递推公式为dp[j]=max(dp[j],dp[j-weight[i]]+val[i]) 即将dp[i-1]换为dp[j]
     * 3、dp数组初始化：全部初始化为0，根据递推公式，dpp[j]取的是一定是最大值，所以其他下标也初始化为0
     * 4、确定遍历顺序：使用一维数组时，遍历背包的顺序要从大到小来保证物品只会放入一次，且必须先遍历物品再遍历背包
     */
    private void knapsackProblem01InOneArray() {
        int weightLength = WEIGHT.length;
        //数组初始化默认全为0，不用进行填充
        int[] dp = new int[BAG_SIZE + 1];

        for (int i = 0; i < weightLength; i++) {
            for (int j = BAG_SIZE; j >= WEIGHT[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - WEIGHT[i]] + VALUE[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        KnapsackProblem problem = new KnapsackProblem();
        problem.knapsackProblem01InOneArray();
    }
}
