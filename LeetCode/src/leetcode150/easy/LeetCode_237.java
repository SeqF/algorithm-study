package leetcode150.easy;

import linkedlist.base.ListNode;

/**
 * 删除链表中的节点
 *
 * 链接:https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class LeetCode_237 {

    /**
     * 将被删除节点的下一个节点复制到被删除节点上，然后再把下一个节点删除
     *
     * @param listNode
     */
    public void deleteNode(ListNode listNode) {
        listNode.data = listNode.next.data;
        listNode.next = listNode.next.next;
    }
}
