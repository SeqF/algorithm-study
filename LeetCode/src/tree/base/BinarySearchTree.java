package tree.base;

/**
 * 二叉查找树
 *
 * @author paksu
 */
public class BinarySearchTree {
    private TreeNode tree;

    /**
     * 1、查找操作
     *
     * @param data
     * @return
     */
    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (data < p.value) {
                p = p.left;
            } else if (data > p.value) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 2、插入操作
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }

        TreeNode p = tree;
        while (p != null) {
            if (data > p.value) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {// data<p.data
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 3、删除操作
     *
     * @param data
     */
    public void delete(int data) {
        //p指向要删除的节点，初始化指向根节点
        TreeNode p = tree;
        //pp记录p的父节点
        TreeNode pp = null;

        //查找要删除的节点
        while (p != null && p.value != data) {
            pp = p;
            if (data > p.value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }

        //3.1 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            //查找右子树的最小节点

            //minP表示最小节点
            TreeNode minP = p.right;
            //minPP表示minP的父节点
            TreeNode minPP = p;
            //找到右子树中的最小节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            //将minP的数据替换到p中
            p.value = minP.value;
            //这里的操作是将删除后多余的最小节点操作，降维为删除最后一个节点,在接下来的方法中就能删除
            p = minP;
            pp = minPP;
        }

        //3.2 删除节点是叶子节点或者仅有一个子节点
        TreeNode child;
        //仅有一个子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //叶子节点
        if (pp == null) {
            tree = null;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

}
