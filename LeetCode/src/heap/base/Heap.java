package heap.base;

/**
 * 堆（默认为大顶堆）
 *
 * @author paksu
 */
public class Heap {

    //保存堆元素的数组，下标从1开始
    private final int[] a;
    //堆的大小
    private final int n;
    //堆中存在的元素个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入元素后(插入到数组最后），自下而上进行堆化，与父节点比较并交换
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        //堆的节点从在数组中从1开始，当节点为n时，左子节点为2n,右子节点为2n+1
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, a[i], a[i / 2]);
            i = i / 2;
        }
    }

    /**
     * 只能删除堆顶元素,将最后一个堆元素与堆顶元素交换，然后从上往下进行堆化
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    /**
     * 自上而下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            //没有到达最后一节点且节点i与左右子节点比较大小，取得子节点中最小的一个
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            //交换之后i移动
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
}
