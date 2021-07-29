package stack.base;

/**
 * 用数组实现一个顺序栈
 * <p>
 * 20,155,232,844,224,682,496.
 */
public class ArrayStack {

    //数组
    private String[] items;
    //栈中元素个数,相当于栈顶指针，指向栈顶的下一个位置
    private int count;
    //栈的大小
    private int n;

    //初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item) {

        //栈满，不能入栈
        if (count == n) {
            return false;
        }
        //入栈后，指针+1
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        String tmp = items[count - 1];
        --count;
        return tmp;
    }

    /**
     * 获得栈顶元素
     * @return
     */
    public String peek(){
        return items[count-1];
    }

}
