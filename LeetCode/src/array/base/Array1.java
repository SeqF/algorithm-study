package array.base;


/**
 * 实现一个支持动态扩容的数组
 */
public class Array1 {

    public String[] data;
    public int count;
    public int size;

    public Array1(int capacity) {
        data = new String[capacity];
        count = 0;
        size = capacity;
    }

    public String[] expand(String[] data) {
        if (count >= size) {
            this.size = this.size * 2;
            String[] newArray = new String[this.size];
            for (int i = 0; i < count; i++) {
                newArray[i] = this.data[i];
            }
            this.data = newArray;
        }
        return this.data;
    }

    public boolean append(String item) {
        if (count >= size) {
            this.data = expand(this.data);
        }
        this.data[count] = item;
        count++;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
