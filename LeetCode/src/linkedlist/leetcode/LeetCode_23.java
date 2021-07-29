package linkedlist.leetcode;

import linkedlist.base.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 题目链接:https://leetcode-cn.com/problems/merge-k-sorted-lists/comments/
 */
public class LeetCode_23 {

    /**
     * 多路归并
     * 参考文章（外部排序）:http://blog.itpub.net/31561269/viewspace-2564096/
     * 参考文章（priority_queue）:https://www.cnblogs.com/fightingcode/p/11616969.html
     * 思路：
     * 直接对NodeLists数组进行归并，但是最后的merge是对链表的merge
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

        int mid = low + (high - low) / 2;
        ListNode list1 = merge(lists, low, mid);
        ListNode list2 = merge(lists, mid + 1, high);
        return mergeTwoList(list1, list2);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if (l1.next == null) {
            return l2;
        }
        if (l2.next == null) {
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode l3 = new ListNode();
        ListNode r = l3;
        while (p.next != null && q.next != null) {

            if (p.data < q.data) {
                r.next = p;
                p = p.next;

                r = r.next;
                r.next = null;
            } else {
                r.next = q;
                q = q.next;

                r = r.next;
                r.next = null;
            }
        }

        if (p.next != null) {
            r.next = p;
        }
        if (q.next != null) {
            r.next = q;
        }
        return l3;
    }

}
