package queue.base;


/**
 * 实现一个链式队列
 */
public class LinkedQueue {

    private Node head = null;
    private Node tail = null;

    public static class Node {

        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return this.data;
        }
    }

    public void enqueue(String item){
        if(tail==null){
            Node newNode=new Node(item,null);
            head=newNode;
            tail=newNode;
        }else {
            tail.next=new Node(item,null);
            tail=tail.next;
        }
    }

    public String dequeue(){
        if(head==null){
            return null;
        }else {
            String value=head.data;
            head=head.next;
            if(head==null){
                tail=null;
            }
            return value;
        }
    }

}
