package leetcode150.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * 扁平化嵌套列表迭代器
 *
 * @author paksu
 *
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 */
public class LeetCode_341 {

    /**
     * 将list转化为N叉树，对N叉树进行前序深度优先遍历
     * N叉树的前序遍历，类比二叉树，就是将孩子节点递归进入
     */
    public class NestedIterator implements Iterator<Integer> {

        int cur = 0;
        List<Integer> path = new ArrayList<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            return path.get(cur++);
        }

        @Override
        public boolean hasNext() {
            return cur!=path.size();
        }

        private void dfs(List<NestedInteger> list){
            for (NestedInteger nestedInteger : list) {
                if (nestedInteger.isInteger()) {
                    path.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }
    }

}
