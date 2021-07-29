package leetcode150.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/min-stack/
 */
public class LeetCode_155 {

    /**
     * 用另一个栈来保存每次push进去时的min，但是产生额外空间
     */
    public class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.max(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 不用额外空间，一个栈
     */
    public class MinStack2 {

        private Stack<Integer> stack;

        public MinStack2() {
            stack = new Stack<>();
        }

        // 当推入数据时，保证原来栈中的最小值是在当前值前面
        // 先将当前元素推入，再判断出当前栈的最小值并推入
        // 1、当推入元素为最小值时，先将原来栈中的最小值push进栈，再将元素推入
        // 2、当推入元素不为最小值时，直接将元素推入
        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                stack.push(val);
            } else {
                int temp = stack.peek();
                stack.push(val);
                stack.push(Math.min(temp, val));
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 2);
        }

        public int getMin() {
            return stack.peek();
        }
    }

}
