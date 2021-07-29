package leetcode150.easy;

import linkedlist.base.ListNode;

/**
 *
 * 反转链表
 *
 * @author paksu
 *
 * 链表：https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 */
public class LeetCode_206 {

    /**
     * 链表反转，用头插法,无头结点
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp;
        ListNode newHead = new ListNode();
        ListNode i = head;
        while (i != null) {
            //拆出链表节点
            temp = i;
            i = i.next;
            //将链表节点插入新的头结点
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }

}
