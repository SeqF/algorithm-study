package queue.base;

/**
 * 用数组实现一个顺序队列
 */
public class ArrayQueue {

    private String[] data;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        data = new String[capacity];
        size = capacity;
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String value) {
        if (tail == size) {
            return false;
        }
        data[tail] = value;
        tail++;
        return true;
    }

    public String dequeue(){
        if(tail==0){
            return null;
        }
        String value=data[head];
        head++;
        return value;
    }
}
