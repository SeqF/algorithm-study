package test;

public class TestThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程一结束");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程二结束");
            }
        });

        threadOne.start();
        threadTwo.start();
        System.out.println("等待所有子线程结束");
        threadOne.join();
        threadTwo.join();
        System.out.println("所有子线程结束");
    }
}
