package stack.base;

/**
 * 用链表实现一个链式栈
 */
public class LinkedStack {

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {

        }
    }

    //栈顶指针,链表插入的第一个节点充当栈底
    private Node t;
    //链表节点个数
    private int count;

    public LinkedStack() {
        t = new Node();
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean empty() {
        return t.next == null;
    }


    /**
     * 入栈操作,头插法，栈顶指针作为头结点
     *
     * @param val
     */
    public void push(int val) {
        Node node = new Node(val, t.next);
        t.next = node;
        count++;
    }

    /**
     * 出栈操作,返回出栈元素的数值
     */
    public Integer pop() {
        if (empty()) {
            return null;
        }
        int val = t.next.data;
        t.next = t.next.next;
        count--;
        return val;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public Integer peek() {
        if (empty()) {
            return null;
        }
        return t.next.data;
    }

    /**
     * 返回栈的元素个数
     * @return
     */
    public int size(){
        return this.count;
    }
}
