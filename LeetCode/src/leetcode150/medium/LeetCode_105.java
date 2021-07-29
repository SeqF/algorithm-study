package leetcode150.medium;

import tree.base.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author ps
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class LeetCode_105 {

    /**
     * 前序遍历获取根节点，然后在中序遍历找到该根节点，对左右子树继续处理
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r2) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.value = preorder[l1];
        int i;
        for (i = l2; i < r2; i++) {
            if (preorder[l1] == inorder[i]) {
                break;
            }
        }
        //获取左右子树在前、中序遍历中的范围
        root.left = createTree(preorder, inorder, l1 + 1, l1 + i - l2, l2, i - 1);
        root.right = createTree(preorder, inorder, l1 + i - l2 + 1, r1, i + 1, r2);
        return root;
    }
}
