package leetcode150.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 存在重复元素
 *
 * @author paksu
 *
 * 链接：https://leetcode-cn.com/problems/contains-duplicate/
 */
public class LeetCode_217 {


    public boolean containDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
