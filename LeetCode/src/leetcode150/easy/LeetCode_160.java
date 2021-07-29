package leetcode150.easy;

import linkedlist.base.ListNode;

/**
 * 相交链表
 *
 * @author pasku
 * <p>
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class LeetCode_160 {


    /**
     * 先计算出两个链表的长度，然后在保证两个链表进行同步移动，相当于长度之差版的快慢指针，然后节点相同时返回
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            countA++;
            a = a.next;
        }
        while (b != null) {
            countB++;
            b = b.next;
        }

        while (headA != null || headB != null) {
            if (countA > countB) {
                headA = headA.next;
                countA--;
            } else if (countA < countB) {
                headB = headB.next;
                countB--;
            } else {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
