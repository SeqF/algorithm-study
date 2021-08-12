package leetcode150.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有序矩阵中第 K 小的元素
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class LeetCode_378 {

    /**
     * 多路归并排序？堆的使用
     * 还有一个方法是，将matrix中的所有元素放进一个维持size为k的大顶堆，然后返回top
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        //构建一个小顶堆
        PriorityQueue<Integer[]> minPq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            //构建一个数组来标记 {当前的值，所在的行，所在的列}
            minPq.offer(new Integer[]{matrix[i][0], i, 0});
        }
        //用小顶堆来不断移除matrix中的最小值，移除k-1个，剩下的第k个就在小顶堆的top
        for (int i = 0; i < k - 1; i++) {
            Integer[] currentMax = minPq.poll();
            if (currentMax[2] != n - 1) {
                minPq.offer(new Integer[]{matrix[currentMax[1]][currentMax[2] + 1], currentMax[1], currentMax[2] + 1});
            }
        }
        return minPq.peek()[0];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        //构建一个大顶堆
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                if (maxPq.size() == k && maxPq.peek() < num) {
                    break;
                }
                maxPq.offer(num);
                if (maxPq.size() > k) {
                    maxPq.poll();
                }
            }
        }
        return maxPq.peek();
    }
}
