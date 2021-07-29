package leetcode150.easy;

import java.util.Arrays;

/**
 * 爬楼梯
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LeetCode_70 {

    private int[] temp;

    /**
     * 递归
     * 1、递推公式：f(n)=f(n-1)+f(n-2)  即爬到楼顶的方法所有方法为f(n),只爬一个台阶的方法为f(n-1)、爬两个台阶的方法为f(n-2)
     * 2、采用记忆化递归，来保存计算过的值（剪枝操作）
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        temp = new int[n + 1];
        Arrays.fill(temp, -1);
        return reClimbStairs(n);
    }

    public int reClimbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (temp[n] == -1) {
            temp[n] = reClimbStairs(n - 1) + reClimbStairs(n - 2);
        }
        return temp[n];
    }
}
