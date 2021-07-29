package stack.leetcode;

import java.awt.*;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LeetCode_32 {

    /**
     * 跟用栈判断括号匹配类似的思路，再匹配成功出栈后进行计数
     * 如果沿用括号匹配的思想，难点在于count置0的时机
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];
        char[] chars = s.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        }
        /**
         * 存储左括号
         */
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                //只存储左括号
                //记录左括号的位置
                stack.push(i);
            } else {
                //多余的右括号舍去.并标记
                if (stack.empty()) {
                    //当栈为空时加入的右括号都是无效匹配
                    mark[i] = 1;
                } else {
                    //由于只存储左括号，右括号加入时一定匹配
                    stack.pop();
                }
            }
        }

        /**
         * 处理剩下的左括号
         */
        while (!stack.isEmpty()) {
            //遍历结束后，剩下的左括号都是无效匹配
            mark[stack.peek()] = 1;
            stack.pop();
        }

        /**
         * 查找标记的最大长度
         */
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1) {
                count = 0;
                continue;
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode_32 leetCode32 = new LeetCode_32();
        String test = "()(())";
        System.out.println(leetCode32.longestValidParentheses(test) == 6);

    }
}
