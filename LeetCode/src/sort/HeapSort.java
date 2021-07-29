package sort;

/**
 * 堆排序
 *
 * @author pasku
 */
public class HeapSort {

    /**
     * 堆排序分为两个步骤：
     * 1、建堆
     * 2、排序
     * 建堆：
     * 有两种思路：
     * 1、一种是按照插入操作，默认堆中只包含一个数据，就是下标为1的数据，然后进行插入操作，
     * 将下标从2到n的数据依次插入到堆中
     * 2、第二种处理思路是从后往前处理数组，每个数据都是从上往下堆化，从n/2到1开始遍历数组，
     * 因为n/2+1到n 的节点都是叶子节点,不需要堆化
     * <p>
     * 排序：
     * 1、建堆结束之后，数组中的数据已经是按照大顶堆的特性来组织的。数组中的第一个元素就是堆顶，也就是最大的元素，
     * 2、把它跟最后一个元素交换，那最大元素就放到了下标为n的位置，
     * 3、然后对剩下的n-1个元素进行堆化，然后再重复操作
     *
     * @param a
     * @param n
     */
    public static void heapSort(int[] a, int n) {
        buildHeap(a, n);
        //k记录未排序的元素个数
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    public static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i > -1; --i) {
            heapify(a, n, i);
        }
    }

    public static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            //查找左右子树中的最大值
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }

}
