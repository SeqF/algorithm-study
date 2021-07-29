package leetcode150.easy;

import tree.base.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class LeetCode_104 {

    int maxDepth;

    /**
     * 递归遍历，每次访问节点前深度+1，求max和depth的最大值
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return maxDepth;
    }

    public void dfs(TreeNode treeNode, int deepth) {
        if (treeNode == null) {
            return;
        }
        deepth++;
        maxDepth = Math.max(deepth, maxDepth);
        dfs(treeNode.left, deepth);
        dfs(treeNode.right, deepth);
    }
}
