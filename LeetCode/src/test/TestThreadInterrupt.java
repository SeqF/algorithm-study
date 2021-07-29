package test;

public class TestThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //do something
                    while (!Thread.currentThread().isInterrupted()) {
                        //do more work
                    }
                } finally {
                    //cleanup, if required
                }
            }
        });

        threadOne.start();
        threadOne.interrupt();
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //System.out.println("isInterrupted:" + threadOne.interrupted());
        System.out.println("isInterrupted:" + Thread.interrupted());
        System.out.println("isInterrupted:" + Thread.interrupted());
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("主线程结束");

    }
}
