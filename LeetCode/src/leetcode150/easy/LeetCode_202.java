package leetcode150.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/happy-number/
 */
public class LeetCode_202 {

    /**
     * 可以知道，不管怎么平方，都不会超过MAX_VALUE，所以不用对极限最大值判断
     * 此问题转换为什么时候会进入死循环来进行退出=======> sum值重复
     * 1、采用set，每次获得新的sum时就放入set中，如果set中有重复就说明有死循环
     * 2、采用快慢指针
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && set.add(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢指针来判断是否有循环
     * 反复调用 getNext(n) 得到的链是一个隐式的链表
     * slow每次只计算一次值，fast每次计算两个值
     * 1、如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字
     * 2、如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            //调用两次getNext来达到快速
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    /**
     * 取num各个位的值
     *
     * @param n
     * @return
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

}
