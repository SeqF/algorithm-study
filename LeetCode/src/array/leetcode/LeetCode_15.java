package array.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 思路：
 * 将三数之和转换为两数之和
 * 即：a+b+c=0 --> a+b=-c
 */
public class LeetCode_15 {

    /**
     * 暴力枚举，三层遍历
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int q = j + 1; q < nums.length; q++) {
                    if (nums[i] + nums[j] + nums[q] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[q]));
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 将值放入map中,变成两层循环
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //对全为0的数组进行单独处理
        if (nums.length > 2 && nums[0] == 0 && nums[nums.length - 1] == 0) {
            result.add(Arrays.asList(0, 0, 0));
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(0 - nums[i] - nums[j])) {
                    result.add(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                }
            }
            map.put(nums[i], i);
        }
        HashSet set = new HashSet(result);
        result.clear();
        result.addAll(set);
        System.out.println(result);
        return result;
    }


    /**
     * 使用双指针来往中间夹
     * 当 i+b+c<0时，说明有一个数偏小，而b是指向除i之外最小的数，所以b++
     * 同理，i+b+c>0时，c++
     * 当 i+b+c=0时，将b和c放入数组，并将b++,c--，因为在排序的情况下，相加为0的值唯一
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 2 && nums[0] == 0 && nums[nums.length - 1] == 0) {
            result.add(Arrays.asList(0, 0, 0));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            //对相同的值 直接略过,去重
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                if (nums[i] + nums[b] + nums[c] > 0) {
                    c--;
                } else if (nums[i] + nums[b] + nums[c] < 0) {
                    b++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[b], nums[c]));
                    //相同的值直接略过,去重
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                }
            }
        }
        return result;
    }

}
