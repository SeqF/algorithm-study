package linkedlist.leetcode;

import linkedlist.base.ListNode;

/**
 * 合并K个升序链表
 *
 * @author paksu
 * 链接:https://leetcode-cn.com/problems/merge-k-sorted-lists/comments/
 */
public class LeetCode_23 {

    /**
     * 多路归并
     * 参考文章（外部排序）:http://blog.itpub.net/31561269/viewspace-2564096/
     * 参考文章（priority_queue）:https://www.cnblogs.com/fightingcode/p/11616969.html
     * 思路：
     * 对数组的列表进行两两归并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        ListNode listA = merge(lists, low, mid);
        ListNode listB = merge(lists, mid + 1, high);
        return mergeTwoList(listA, listB);
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode curA = a;
        ListNode curB = b;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode temp;
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                temp = curA;
                curA = curA.next;
            } else {
                temp = curB;
                curB = curB.next;
            }
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next;
        }

        if (curA != null) {
            cur.next = curA;
        }
        if (curB != null) {
            cur.next = curB;
        }
        return dummyHead.next;
    }

}
