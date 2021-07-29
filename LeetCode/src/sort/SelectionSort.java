package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author paksu
 */
public class SelectionSort {

    /**
     * 实现思路与插入排序类似，也分已排序区和未排序区。
     * 选择排序每次从未排序区中选择一个最小的元素，与已排序区的末尾进行交换
     * <p>
     * 是不稳定的排序算法，时间复杂度为O(n^2)
     *
     * @param a 表示存放数据的数组
     * @param n 表示数组大小
     */
    public void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int j = i;
            int min = a[j];
            //记录最小值的数组下标
            int k = j;
            for (; j < n - 1; j++) {
                if (min > a[j + 1]) {
                    min = a[j + 1];
                    k = j + 1;
                }
            }
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] test = {4, 5, 6, 3, 2, 1};
        sort.selectionSort(test, test.length);
        System.out.println(Arrays.toString(test));
    }
}
