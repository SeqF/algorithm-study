package leetcode150.easy;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class LeetCode_88 {

    /**
     * 简单粗暴，直接把nums2放在nums1里再对nums1排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针：new一个新数组来保存结果，在赋值到nums1，跟链表归并一样，但是不想浪费存储空间
     * 逆向双指针，利用nums1后面多余的空间，不用new一个新的数组来保存结果
     * 由一个看不懂的不等式可以知道，nums1后面永远都够放入元素
     * 利用nums1、nums2的升序的特点，从后面往前遍历，将大的放进nums的最后面，即m+n-1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            //m=0的情况
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                //n=0的情况
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
