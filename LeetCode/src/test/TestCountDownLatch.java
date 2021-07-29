package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author paksu
 */
public class TestCountDownLatch {

    //请求线程的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(()->{
                try {
                    //test方法模拟请求的耗时
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //请求完成后调用countDown
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println(Thread.currentThread().getName()+"进入await");
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println(Thread.currentThread().getName()+"Finish");

    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum："+threadNum);
        Thread.sleep(1000);
    }
}
