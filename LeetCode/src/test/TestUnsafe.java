package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author paksu
 */
public class TestUnsafe {

    //获取Unsafe的实例
    static final Unsafe UNSAFE;
    //记录变量state在类TestUnsafe中的偏移值
    static final long stateOffset;
    //变量
    private volatile long state = 0;

    static {
        try {
            //通过反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            UNSAFE =(Unsafe) field.get(null);
            //获取state变量在类TestUnSafe中的偏移值
            stateOffset = UNSAFE.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例，并设置state值为1
        TestUnsafe test = new TestUnsafe();
        boolean success = UNSAFE.compareAndSwapLong(test, stateOffset, 0, 1);
        System.out.println(success);
    }

}
