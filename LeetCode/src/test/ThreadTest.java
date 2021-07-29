package test;

import javax.swing.border.CompoundBorder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author paksu
 */
public class ThreadTest {

    /**
     * 继承Thread类并重写run方法
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我是子线程");
        }
    }


    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("我是子线程");
        }
    }

    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }


    public static void main(String[] args) throws InterruptedException{
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try{
            //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }

}
