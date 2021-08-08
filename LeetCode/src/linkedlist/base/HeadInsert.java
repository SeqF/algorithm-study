package linkedlist.base;

/**
 * 头插法构建链表(带虚拟头节点)
 *
 * @author paksu
 */
public class HeadInsert {
    //虚拟头结点
    ListNode head;

    public ListNode insertAtHead(int val) {
        ListNode toAdd = new ListNode(val);
        toAdd.next = head.next;
        head.next = toAdd;
        return head.next;
    }
}
