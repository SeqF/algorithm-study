package leetcode150.easy;

/**
 * 最大子序和
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LeetCode_53 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = nums[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return Math.max(dp[0], result);
    }

    public static void main(String[] args) {
        LeetCode_53 code53 = new LeetCode_53();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(code53.maxSubArray(nums));
    }
}
