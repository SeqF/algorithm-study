package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadSleep {

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    System.out.println("线程A正在睡眠");
                    Thread.sleep(10000);
                    System.out.println("线程A已经苏醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try {
                    System.out.println("线程B正在睡眠");
                    Thread.sleep(10000);
                    System.out.println("线程B已经苏醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();
    }
}
