package leetcode150.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
 */
public class LeetCode_22 {

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    /**
     * 用回溯法的模板可以往上套，重点是如何判断合格的括号序列,相当于是剪枝
     * 1、肯定是 ( 比 ) 先加入path
     * 2、( 、)的数量匹配
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        backTracking(n, 0, 0, path);
        return result;
    }

    /**
     * right、left来记录左右括号的数量
     *
     * @param n
     * @param left
     * @param right
     * @param path
     */
    private void backTracking(int n, int left, int right, StringBuilder path) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }
        if (left < n) {
            path.append('(');
            backTracking(n, left + 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            backTracking(n, left, right + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
