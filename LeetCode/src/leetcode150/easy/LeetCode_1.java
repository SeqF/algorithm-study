package leetcode150.easy;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_1 {

    /**
     * 思路：
     * 1、两数之和，target = nums[i] + x，那么反过来就是看x是否存在于nums中
     * 2、x = target - nums[i]，存储在map中,即为i下标所对应的x
     * 3、遍历数组，每次存储进map之前，检查nums[i]是否为map中存储的x，如果符合则返回结果;
     * 不符合就把该nums[i]对应的x存入map中
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

}
