package queue.LeetCode;

/**
 * 设计实现双端队列。
 * <p>
 * 你的实现需要支持以下操作：
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * <p>
 * 示例：
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 * <p>
 * 提示：
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/design-circular-deque/
 */
public class LeetCode_641 {

    public static class MyCircularDeque {

        int size;
        int[] data;
        //front指向队头元素前一个
        int front;
        //rear指向队尾元素
        int rear;


        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = k;
            this.data = new int[k];
            this.front = 0;
            this.rear = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            data[front] = value;
            front = (front - 1 + size) % size;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % size;
            data[rear] = value;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % size;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1) % size;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            int index = (front + 1) % size;
            return data[index];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return data[rear];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return rear == front;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return front == (rear + 1) % size;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(10);
        circularDeque.insertLast(3);
        circularDeque.insertLast(1);
        circularDeque.insertLast(2);
        circularDeque.insertLast(3);
        circularDeque.insertLast(4);
        circularDeque.insertFront(4);
//        System.out.println(circularDeque.insertLast(9));
//        System.out.println(circularDeque.insertLast(9));
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.isFull());
//        System.out.println(circularDeque.deleteLast());
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.getFront());
        for (int i = 0; i < circularDeque.size; i++) {
            System.out.print(circularDeque.data[i]);
        }
    }
}
