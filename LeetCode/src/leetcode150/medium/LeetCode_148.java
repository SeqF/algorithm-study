package leetcode150.medium;

import linkedlist.base.ListNode;

/**
 * 排序链表
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/sort-list/
 */
public class LeetCode_148 {

    /**
     * 用归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //使用快慢指针找出mid
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode list = new ListNode();
        ListNode cur = list;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) {
            cur.next = right;
        }
        if (right == null) {
            cur.next = left;
        }
        return list.next;
    }
}
