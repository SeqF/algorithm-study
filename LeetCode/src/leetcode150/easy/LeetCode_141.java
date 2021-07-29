package leetcode150.easy;

import linkedlist.base.ListNode;

/**
 * 环形链表
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LeetCode_141 {

    /**
     * 快慢指针,fast追上slow即有环，注意无环情况的判断
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
