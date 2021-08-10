package leetcode150.medium;

import tree.base.TreeNode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.WeakHashMap;

/**
 * 二叉树的层次遍历
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LeetCode_102 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);
        while (!treeQueue.isEmpty()) {
            List<Integer> floor = new ArrayList<>();
            int size = treeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeQueue.poll();
                floor.add(node.val);
                if (node.left != null) {
                    treeQueue.offer(node.left);
                }
                if (node.right != null) {
                    treeQueue.offer(node.right);
                }
            }
            result.add(new ArrayList<>(floor));
        }
        return result;
    }
}
