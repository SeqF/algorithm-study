package leetcode150.medium;

import linkedlist.base.ListNode;

/**
 * 奇偶链表
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class LeetCode_328 {

    /**
     * 把链表分为奇链表和偶链表，然后合并
     * 麻痹链表操作全寄吧忘了
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        int two = 2;
        int count = 1;
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            if (count % two != 0) {
                temp.next = odd.next;
                odd.next = temp;
                odd = odd.next;
            }else {
                temp.next = even.next;
                even.next = temp;
                even = even.next;
            }
            count++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
