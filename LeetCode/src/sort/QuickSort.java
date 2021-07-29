package sort;

import java.util.Arrays;
import java.util.List;

/**
 * 快速排序
 *
 * @author paksu
 */
public class QuickSort {

    /**
     * 快速排序算法：如果要排序数组中 下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot(分区点)
     * 遍历p到r之间的数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间。
     * 这样，数组p到r之间的数据就被分成了三个部分，前面p到q之间的都是小于pivot的，中间是pivot，后面的q+1到r之间是大于pivot的，
     * 运用递归的思想，直到区间缩小为1，则排序完成
     * <p>
     * 是原地、不稳定的算法，时间复杂度为(nlogn)
     *
     * @param a
     * @param n
     */
    public void quickSort(int[] a, int n) {
        quickSortC(a, 0, n - 1);
    }

    public void quickSortC(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        //重点是这个分区方法
        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    public int partition(int[] a, int p, int r) {
        //使用数组最后一个元素作为中枢,划分为左小右大
        int pivot = a[r];
        int i = p;
        //i为已处理区最后一个元素的位置，j为未处理区的第一个元素位置，把j小于pivot的元素通过swap放在已处理区
        //遇到比中枢小的元素就跟就把i、j交换，然后i++,j++。否则，i不动，j继续遍历。相当于i是记录找到的大于中枢的元素，把他放到后面
        for (int j = p; j <=r - 1; j++) {
            if (a[j] < pivot) {
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        return i;
    }

    public void swap(int[] a,int f, int r) {
        int temp = a[f];
        a[f] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] test = new int[]{6, 11, 3, 9, 8};
        sort.quickSort(test,test.length);
        System.out.println(Arrays.toString(test));
    }
}
