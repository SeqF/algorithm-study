package linkedlist.base;

/**
 * 单链表节点:
 * 1、数据域
 * 2、指针域
 */
public class ListNode {

    public int data;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

}
