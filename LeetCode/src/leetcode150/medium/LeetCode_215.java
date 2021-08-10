package leetcode150.medium;

import sort.QuickSort;

/**
 * 数组中的第K个最大元素
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class LeetCode_215 {

    int result = 0;

    /**
     * 用快排，快排每次分区都会确定一个pivot的位置，根据这个pivot来确定k的范围并返回
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        partition(nums, 0, nums.length - 1, k-1);
        return result;
    }

    private void partition(int[] nums, int p, int r, int k) {
        if (p == k || r == k) {
            result = nums[k];
        }
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] > pivot) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, i, r);
        if (i > k) {
            partition(nums, p, i - 1, k);
        } else if (i < k) {
            partition(nums, i + 1, r, k);
        } else {
            result = nums[i];
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
