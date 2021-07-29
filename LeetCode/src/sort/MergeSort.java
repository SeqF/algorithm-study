package sort;

/**
 * 归并排序
 *
 * @author paksu
 */
public class MergeSort {

    /**
     * 归并排序：采用的是分治的思想，如果要排序一个数组，先把数组从中间分成前后两部分，然后对前后两部分 分别排序
     * 再讲排好序的两部分合并在一起，这样整个数组就有序了
     * <p>
     * 稳定的排序算法，时间复杂度为O(nlogn)
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] a, int low, int mid, int high) {

        //新建一个B数组来保存A数组中的元素
        int[] b = new int[]{};
        int k;

        //将A数组中的元素放入B数组中
        for (k = low; k <= high; k++) {
            b[k] = a[k];
        }

        int i, j;
        //直接在一个数组上进行比较
        //k表示a数组的位置，i表示从左边那段数组开始，j表示从右边那段数组开始，对两段数组进行比较
        //将较小的元素放回a数组中
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (b[i] <= b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }

        //将剩余的数组放入a数组中
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    public void mergeSort(int[] a, int low, int high) {
        int mid = (high + low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        //重点就是这个merge方法
        merge(a, low, mid, high);
    }
}
