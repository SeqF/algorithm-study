package test;

public class TestStatic {

    public TestStatic() {
        System.out.println("默认构造方法！");
    }

    {
        System.out.println("非静态代码块！");
    }

    static {
        System.out.println("静态代码块！");
    }

    private static void test() {
        System.out.println("静态方法中的内容");
        {
            System.out.println("静态方法中的代码块");
        }
    }

    public static void main(String[] args) {
//        TestStatic testStatic = new TestStatic();
        TestStatic.test();
    }
}
