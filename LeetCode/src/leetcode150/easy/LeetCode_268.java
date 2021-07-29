package leetcode150.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 丢失的数字
 *
 * @author paksu
 *
 * 链接：https://leetcode-cn.com/problems/missing-number/
 */
public class LeetCode_268 {

    /**
     * 排序之后，每次遍历数组都计数。不符合的元素则返回计数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {
            if (count != num) {
                return count;
            }
            count++;
        }
        return count;
    }

    /**
     * 哈希表,将数组存入set中，然后用数组长度来对set进行检查
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
