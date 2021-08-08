package linkedlist.base;

/**
 * 尾插法构建链表(带虚拟头节点)
 * @author paksu
 */
public class TailInsert {

    //虚拟头节点
    ListNode head;

    public ListNode insertAtTail(int val) {
        ListNode toAdd = new ListNode(val);
        ListNode r = head;
        toAdd.next = r.next;
        r.next = toAdd;
        r = r.next;
        return head.next;
    }
}
