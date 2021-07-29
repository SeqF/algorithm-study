package leetcode150.medium;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class LeetCode_238 {

    /**
     * 乘积=左边的乘积*右边的乘积
     * 分别计算左边的乘积和右边的乘积，然后相乘
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_238 code238 = new LeetCode_238();
        System.out.println(Arrays.toString(code238.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
