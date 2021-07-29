package leetcode150.medium;

import tree.base.TreeNode;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class LeetCode_230 {

    /**
     * 中序遍历二叉查找树，输出的是有序序列，然后输出k位置的元素
     *
     * @param root
     * @param k
     * @return
     */
    int count = 1;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        if (count > k || node == null) {
            return;
        }
        inOrder(node.left, k);
        if (count == k) {
            result = node.value;
        }
        count++;
        inOrder(node.right, k);
    }
}
