package stack.leetcode;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: '()'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: '()[]{}'
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: '(]'
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: '([)]'
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: '{[]}'
 * 输出: true
 */
public class LeetCode_20 {

    /**
     * 根据匹配条件入栈 ()、[]、{}
     * 1.第一个入栈元素为右括号时直接返回 false
     * 2.每次入栈时进行与栈顶元素的匹配判断,如果匹配则出栈，不匹配就入栈
     * 3.当全部字符串检测完后，栈内还有元素，则校验不通过
     *
     * @param s
     * @return boolean
     */
    public boolean isValid(String s) {

        if (s.isEmpty()) {
            return false;
        }

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

    public static void main(String[] args) {
        LeetCode_20 code20 = new LeetCode_20();
        boolean valid = code20.isValid("()");
        System.out.println(valid);
    }
}
