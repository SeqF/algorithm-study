package leetcode150.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class LeetCode_138 {

    /**
     * 用hashmap来存节点之间的关系？
     * 将每个节点保存下来，然后再一一赋值
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>(16);
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            map.put(cur, clone);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
