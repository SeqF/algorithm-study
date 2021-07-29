package test;

public class TestThreadDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        System.out.println("主线程已经结束");
    }
}
