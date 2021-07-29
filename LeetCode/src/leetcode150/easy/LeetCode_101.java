package leetcode150.easy;

import tree.base.TreeNode;

/**
 * 对称二叉树
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class LeetCode_101 {

    /**
     * 符合对称的条件：左的左等于右的右，左的右等于右的左
     * 当符合对称对称条件时，进入下一层的比较
     * 当不符合对称条件时，判断节点是不是为空
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkChild(root.left, root.right);
    }

    private boolean checkChild(TreeNode leftNode,TreeNode rightNode) {

        //循环体，每次进行 左节点的左和右节点的右，左节点的右和右节点的左 比较
        if (leftNode != null && rightNode != null && leftNode.value == rightNode.value) {
            return checkChild(leftNode.left, rightNode.right) && checkChild(leftNode.right, rightNode.left);
        }
        //递归出口，当不满足对称条件时，判断是否为空
        return leftNode == null && rightNode == null;
    }
}
