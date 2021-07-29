package sort;

/**
 * 插入排序
 *
 * @author paksu
 */
public class InsertionSort {

    /**
     * 将数组中的元素分为两个区间，已排序区和未排序区，初始已排序区只有一个元素，就是数组的第一个元素。
     * 核心思想是取未排序区中的元素，在已排序区中找到合适的插入位置将其插入，并保证已排序区一直有序，直到未排序区为空
     * <p>
     * 是稳定的排序算法，时间复杂度为O(n^2)
     *
     * @param a 表示数组
     * @param n 表示数组大小
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        //从i=1开始遍历，i=0也就是第一个元素默认为已排序区，所以从i=1开始遍历，就是从未排序区开始遍历
        for (int i = 1; i < n; ++i) {
            //获取未排序区的第一个元素
            int value = a[i];
            //i-1就是已排序区的最后一个元素
            int j = i - 1;
            //查找插入的位置，遍历已排序区
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    //移动元素
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入元素
            a[j + 1] = value;
        }
    }
}
