package leetcode150.easy;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author pasku
 */
public class LeetCode_118 {

    /**
     * 终极无敌坑的List<List<Integer>>!!!
     * 二维链表的初始化与遍历：https://www.baeldung.com/java-multi-dimensional-arraylist
     *
     * 先想象构造成numRows x numRows 的矩阵，然后取矩阵的下半部分，即i>=j的下三角部分
     * 1、当j=0时或者i=j时，数组元素为1
     * 2、a[i][j]=a[i-1][j-1]+a[i-1][j]，即任意位置的元素等于上列左边的元素和正上方的元素之和(在直角情况下观察）
     * 3、要输出为三角形，加个换行即可
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> arr = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            //下三角的每个数组长度都为对应的i+1
            arr.add(new ArrayList<>(i + 1));
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    arr.get(i).add(1);
                } else {
                    arr.get(i).add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_118().generate(5).toString());
    }
}
