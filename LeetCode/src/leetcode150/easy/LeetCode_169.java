package leetcode150.easy;

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/majority-element/
 */
public class LeetCode_169 {

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    major = nums[i];
                    //major换了之后还要将count重新计数为1
                    count = 1;
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
        LeetCode_169 code169 = new LeetCode_169();
        System.out.println(code169.majorityElement(new int[]{2,2,1,3,1,1,4,1,1,5,1,1,6}));
    }
}
