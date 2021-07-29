package tree.base;

/**
 * @author paksu
 */
public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {

    }
}
