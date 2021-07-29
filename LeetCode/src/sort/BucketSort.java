package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 *
 * @author paksu
 */
public class BucketSort {

    /**
     * 桶排序的核心思想是将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。桶内排序完之后，
     * 再把桶里的数据按照顺序依次取出，组成的序列就是有序的了
     * 注意：桶排序对于数据的要求非常苛刻：
     * 1、要排序的数据需要容易划分为n个桶，
     * 2、数据在各个桶之间的分布是比较均匀，当数据不均匀时，桶内的排序算法就不再是常量级
     * 桶排序比较适合用在外部排序
     * <p>
     * 时间复杂度为O（n），即线性排序，是非基于比较的排序算法
     */
    public void bucketSort(int[] data) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int value : data) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        //区间跨度（求平均值）=（最大值-最小值）/(桶的数量-1)----->（桶的数量）=（最大值-最小值）/(区间跨度)+1
        //区间跨度即为所求数组的数组长度
        int bucketNum = (max - min) / data.length + 1;
        ArrayList<ArrayList<Integer>> bucketArray = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArray.add(new ArrayList<>());
        }

        //将每个元素放入桶
        for (int i = 0; i < data.length; i++) {
            int num = (data[i] - min) / data.length;
            bucketArray.get(num).add(data[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArray.size(); i++) {
            Collections.sort(bucketArray.get(i));
        }

        //将桶中的元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucketArray.size(); i++) {
            for (int j = 0; j < bucketArray.get(i).size(); j++) {
                data[index++] = bucketArray.get(i).get(j);
            }
        }
    }
}
