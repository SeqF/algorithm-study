package test;

/**
 * @author paksu.fang
 */
public class TestThreadNotSafeInteger {

    private int value;

    public synchronized int getCount() {
        return value;
    }

    public synchronized void inc() {
        ++value;
    }
}
