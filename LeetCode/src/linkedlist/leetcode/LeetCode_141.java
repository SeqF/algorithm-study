package linkedlist.leetcode;

import linkedlist.base.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class LeetCode_141 {

    /**
     * 快慢指针
     * 定义两个指针，fast、slow, fast每次走两步，slow每次走一步，当链表中存在环时，fast跟slow一定会在环中相遇
     * 证明：https://leetcode-cn.com/problems/find-the-duplicate-number/comments/660994
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while (p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
