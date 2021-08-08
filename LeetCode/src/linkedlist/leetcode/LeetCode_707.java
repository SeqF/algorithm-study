package linkedlist.leetcode;

import linkedlist.base.ListNode;

/**
 * 设计链表
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/design-linked-list/
 */
public class LeetCode_707 {
    private class MyLinkedList{
        int size;
        //虚拟头结点
        ListNode head;
        
        public MyLinkedList(){
            size = 0;
            head = new ListNode();
        }

        //获取第index个节点的数值
        public int get(int index) {
            //如果index非法，返回-1
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currentNode = head;
            //包含头节点，所以查找第index+1个节点
            for (int i = 0; i <=index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        //在链表最前面插入一个节点
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //在链表的最后插入一个节点
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 在第 index 个节点之前插入一个新节点，如果 index 为0，那么新插入的节点为链表的新头节点
        // 如果 index 等于链表的长度，则说明新插入的节点为链表的尾节点
        // 如果 index 大于链表的长度，则返回空
        private void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到要插入节点的前驱
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pre.next;
            pre.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
    }
}
