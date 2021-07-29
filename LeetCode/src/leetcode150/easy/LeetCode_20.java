package leetcode150.easy;

import java.util.Deque;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class LeetCode_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char t : chars) {
            if (stack.isEmpty() && (')' == t || '}' == t || ']' == t)) {
                return false;
            }
            if (stack.isEmpty()) {
                stack.push(t);
            } else {
                char peek = stack.peek();
                if ('(' == peek && ')' == t) {
                    stack.pop();
                } else if ('{' == peek && '}' == t) {
                    stack.pop();
                } else if ('[' == peek && ']' == t) {
                    stack.pop();
                } else {
                    stack.push(t);
                }

            }
        }
        return stack.isEmpty();
    }
}
