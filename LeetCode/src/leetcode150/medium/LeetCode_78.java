package leetcode150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets/
 */
public class LeetCode_78 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 这个就是组合的回溯解法基础上，不限定树的深度，获取所有的路径
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(Integer.valueOf(nums[i]));
        }
    }

    public static void main(String[] args) {
        LeetCode_78 code78 = new LeetCode_78();
        System.out.println(code78.subsets(new int[]{1, 2, 3, 4}).toString());
    }
}
