package leetcode150.easy;

/**
 * 移动零
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/move-zeroes/
 */
public class LeetCode_283 {

    /**
     * 借助快排的思想：
     * 以0为一个分割点,将数组划分为非零数和0，j表示为为处理区域，i表示为已处理区域
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = 0;
        while (j < length) {
            if (nums[j] != 0) {
                swap(nums, j, i);
                i++;
            }
            j++;
        }
    }

    public void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}
