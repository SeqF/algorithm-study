package test;

public class TestThreadLocal {

    //1. print函数
    static void print(String str) {
        //1.1 打印当前线程本地内存中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        //1.2 清除当前线程本地内存中的localVariable变量
//        localVariable.remove();
    }

    //2. 创建ThreadLocal
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        //3. 创建线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                //3.1 设置线程One中本地变量localVariable的值
                localVariable.set("线程一的本地变量1");
                localVariable.set("线程一的本地变量2");
                //3.2 调用打印函数
                print("线程一");
                //3.3 打印本地变量值
                System.out.println("线程一删除后" + ":" + localVariable.get());
            }
        });
        //4. 创建线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                //4.1 设置线程Two中本地变量localVariable的值
                localVariable.set("线程二的本地变量");
                //4.2 调用打印函数
                print("线程二");
                //4.3 打印本地变量值
                System.out.println("线程二删除后" + ":" + localVariable.get());
            }
        });
        //5.启动线程
        threadOne.start();
        threadTwo.start();
    }
}
