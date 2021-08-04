package leetcode150.medium;

/**
 * 不同路径
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/unique-paths/
 */
public class LeetCode_62 {

    /**
     * 动态规划，
     * 1、dp数组含义：dp[i][j]表示为到达m=i,n=j的位置有dp[i][j]种方法
     * 2、递推公式：机器人每次只能向下或向右走一步->dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * 3、dp数组初始化：dp[i][0]=1,dp[0][j]=1
     * 4、遍历顺序：从前往后
     * 5、举例推导dp数组：m=3,n=7,->dp=[[1,1,1,1,1,1,1],[1,2,3,4,5,6,7],[1,3,6,10,15,21,28]]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //行的填充
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //列的填充
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
