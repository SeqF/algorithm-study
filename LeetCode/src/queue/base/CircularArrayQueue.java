package queue.base;

/**
 * 循环队列，使用数组实现
 */
public class CircularArrayQueue {

    private String[] data;
    //front指向队头元素的前一个位置
    private int front;
    //rear指向队尾
    private int rear;
    private int maxSize;

    public CircularArrayQueue(int capacity){
        this.front=this.rear=0;
        this.maxSize=capacity;
    }

    /**
     * 判空
     * @return
     */
    boolean isEmpty(){
        if(front==rear){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 入队
     * @param value
     * @return
     */
    boolean enQueue(String value){
        if((rear+1)%maxSize==front){
            return false;
        }
        data[rear]=value;
        rear=(rear+1)%maxSize;
        return true;
    }

    /**
     * 出队
     * @return
     */
    String deqQueue(){
        if(front==rear){
            return null;
        }
        String x=data[front];
        front=(front+1)%maxSize;
        return x;
    }
}
