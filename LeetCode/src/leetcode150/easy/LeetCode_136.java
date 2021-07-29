package leetcode150.easy;

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/single-number/
 */
public class LeetCode_136 {

    /**
     * 数组排序之后计数，
     * 异或：相同为0，不同为1. 异或同一个数两次，原数不变。
     *  1、交换律：a ^ b ^ c <=> a ^ c ^ b
     *  2、任何数于0异或为任何数 0 ^ n => n
     *  3、相同的数异或为0: n ^ n => 0
     *
     *  例如：var a = [2,3,2,4,4]
     *       2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
