package leetcode150.easy;

import tree.base.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class LeetCode_108 {

    /**
     * 原数组为升序，用二分查找，每三个节点就是一颗树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode binarySortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int middle = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[middle], null, null);
        root.left = binarySortedArrayToBST(nums, low, middle - 1);
        root.right = binarySortedArrayToBST(nums, middle + 1, high);
        return root;
    }


    public static void main(String[] args) {
        LeetCode_108 solution = new LeetCode_108();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(solution.sortedArrayToBST(nums));
    }
}
