package leetcode150.medium;

import test.Test;

/**
 * 分割等和子集
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class LeetCode_416 {

    /**
     * 思路：只要找到总数和为sum/2的子集，那就是能分割成两个相同元素和的子集
     * 套用01背包解决 -> 背包体积为sum/2，物品为元素，weight为元素数值，value也为元素数值
     * 1、确定dp数组：dp[j]表示为，背包总容量是j（sum/2），最大可以凑成的子集总和为dp[j]
     * 2、确定递推公式：dp[j]=max(dp[j],dp[j-weight[i]+value[i])
     * 3、dp数组初始化：价值都是正整数，全部初始化为0
     * 4、遍历顺序：用一维dp数组时，要物品再最外层，背包在内层且倒序遍历
     * 5、推导dp数组：如果dp[j]==j，那就是子集的元素总和(dp[j])就等于sum/2(j)，即可返回true
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //只有sum为偶数时，才能进行01背包划分，否则直接返回false
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        LeetCode_416 leetCode416 = new LeetCode_416();
        int[] test = {1, 2, 3, 5};
        leetCode416.canPartition(test);
    }
}
