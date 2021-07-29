package leetcode150.easy;

import linkedlist.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class LeetCode_234 {

    /**
     * 回文，即从前往后读和从后往前读是一样的
     * 将链表放进一个数组中，再双指针来进行检查
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode p = head;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 可以用链表的快慢指针来找到链表的中点，然后进行后半部分的链表倒置，然后比较是否一样
     * fast每次走两步、slow每次走一步，当fast指针走到末尾时，slow即为中间节点
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.data != p2.data) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //复原链表
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //将当前的节点的next指针改为指向前一个节点
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
