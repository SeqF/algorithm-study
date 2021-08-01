package leetcode150.medium;

import linkedlist.base.ListNode;

/**
 * 环形链表2，寻找入环点
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LeetCode_142 {

    /**
     * 快慢指针，根据公式推导，当slow和fast相遇时，cur从head出发与slow同步移动，当相遇时，cur就是入环点
     * 详情看题解
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}
