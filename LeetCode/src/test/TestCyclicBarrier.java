package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author paksu
 */
public class TestCyclicBarrier {

    private static final int threadCount = 50;
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5,()->{
        System.out.println("线程全部到达屏障后，优先执行");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum:" + threadNum + "is ready");
        try {
            CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("---------CYCLIC_BARRIER_EXCEPTION---------");
        }
        System.out.println("threadNum:" + threadNum + "is finished");
    }
}
