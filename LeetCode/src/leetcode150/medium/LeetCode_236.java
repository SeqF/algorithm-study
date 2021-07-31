package leetcode150.medium;


import tree.base.TreeNode;

/**
 * 二叉树的最近公共祖先
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LeetCode_236 {

    /**
     * 树的后序遍历，自底向上
     * 在树的后续遍历基础上进行查询结果的向上传递
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
//        if (left !=null && right !=null) {
//            return root;
//        } else if (left == null && right == q) {
//            return right;
//        } else if (right == null && left == p) {
//            return left;
//        }else {
//            return null;
//        }
        //逻辑简化
        if (left != null && right != null) {
            //当left和right都不为空时，即找到目标节点，其左右子节点都符合条件，此时将root返回
            return root;
        }
        if (left == null) {
            //当左节点为空，右节点不为空，说明右子树找到了目标节点，此时将right返回;左子树同理
            return right;
        }
        return left;
    }
}
