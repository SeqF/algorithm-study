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
     *  定义一个cur指针，指向头结点，再定义一个pre指针，初始化为null
     *  cur->next 节点用tmp指针保存一下
     *  cur->next指向pre，即完成了反转，然后移动cur和pre
     *  当cur指向null，即完成了反转，返回pre
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            //保存下一个节点
            temp = cur.next;
            //反转
            cur.next = pre;
            //移动
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
