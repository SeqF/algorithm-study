package leetcode150.easy;

import com.sun.xml.internal.ws.util.StringUtils;
import linkedlist.base.ListNode;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 合并两个有序链表
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode_21 {

    /**
     * 归并,尾插，一开始弄成头插法了
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode list = new ListNode();
        if (l1 == null && l2 == null) {
            return list.next;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode c = list;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                c.next = l1;
                l1 = l1.next;
            } else {
                c.next = l2;
                l2 = l2.next;
            }
            c = c.next;
        }
        if (l1 == null) {
            c.next = l2;
        }
        if (l2 == null) {
            c.next = l1;
        }
        return list.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        l1.next = new ListNode(2);
        l2.next = new ListNode(3);

        l1.next.next = new ListNode(4, null);
        l2.next.next = new ListNode(4, null);

        LeetCode_21 code21 = new LeetCode_21();
        ListNode node = code21.mergeTwoList(l1, l2);
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.data);
            node = node.next;
        }
        System.out.println(stringBuilder.toString());

    }

}
