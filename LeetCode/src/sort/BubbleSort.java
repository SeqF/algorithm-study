package sort;

/**
 * @author paksu
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序只会操作相邻的两个数据，每次冒泡操作都会对相邻的两个元素进行比较，查看是否满足大小关系
     * 如果不满足就会进行交换，每进行一次冒泡都会让至少一个元素移动到正确的位置
     * <p>
     * 稳定的排序算法,时间复杂为 O(n^2)
     *
     * @param a 表示数组
     * @param n 表示数组大小
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // -i是排除已排序好的元素，-1是为了不会跟底部排好序的元素继续比较
            for (int j = 0; j < n - i - 1; j++) {
                if (a[i] > a[j + 1]) {
                    int temp = a[i];
                    a[i] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
