package array.leetcode;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * <p>
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class LeetCode_41 {

    /**
     * hash碰撞检测法
     *
     * 思路：遍历一次数组，将大于0且小于数组长度的元素放在数组响应下标的位置上，
     * 然后再遍历一次数组，当下标与存储的元素不符时，此下标就是缺少的最小整数
     *
     *  i => 数组的下标
     *  nums[i] => 数组下标对应的正确数值
     *
     * @param
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            // <=0、>nums.length和重复的元素 不用进行移动
            // 符合条件的元素则放到相应的数组位置上（交换）
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        //再次对数组进行一次遍历，不在对应位置上的元素时，返回其数组下标+1，即是该位置上对应的数值
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

}
