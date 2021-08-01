package leetcode150.medium;

/**
 * 寻找重复数
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/comments/
 */
public class LeetCode_287 {

    /**
     * 用寻找入环点的思路来做，将数组抽象成链表
     * 要点：
     *    1、数组抽象成链表，将值作为数组下标，将数组构建为一个新链表（因为值限定在1~n，不会产生溢出）
     *    2、采用循环链表2，寻找入环点的思路
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        int cur = 0;
        while (true) {
            fast=nums[nums[fast]];
            slow=nums[slow];
            if (slow==fast) {
                while (cur!= slow) {
                    slow=nums[slow];
                    cur=nums[cur];
                }
                return cur;
            }
        }
    }
}
