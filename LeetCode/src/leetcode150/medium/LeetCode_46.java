package leetcode150.medium;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全排列
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations/
 */
public class LeetCode_46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer, Boolean> map = new HashMap<>();

    /**
     * 还是用到回溯算法，这次的思想是如何在访问到所有元素的情况下，排除已访问的元素
     * 1、使用hash表，标记已访问的元素，当该元素已经被加入path时，就不对该元素进行操作
     * 2、未访问的元素继续操作
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (Boolean.FALSE.equals(map.get(nums[i]))) {
                path.add(nums[i]);
                map.put(nums[i], Boolean.TRUE);
                backTracking(nums, 0);
                path.remove(Integer.valueOf(nums[i]));
                map.put(nums[i], Boolean.FALSE);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_46 code46 = new LeetCode_46();
        System.out.println(code46.permute(new int[] {1,2,3}).toString());
    }
}
