package array;

import array.base.Array1;
import array.base.Array2;
import array.leetcode.LeetCode_1;
import array.leetcode.LeetCode_15;
import array.leetcode.LeetCode_169;
import array.leetcode.LeetCode_41;

public class Solution {

    public static void main(String[] args) {

//        Array1 array = new Array1(5);
//        for (int i = 0; i < array.size; i++) {
//            array.data[i]="key"+i;
//            array.count++;
//        }
//        array.append("key5");
//        System.out.println(array.size);
//
//
//        Array2 array2=new Array2(5);
//        array2.insert(1);
//        array2.insert(2);
//        array2.insert(2);
//        array2.insert(2);
//        array2.insert(3);
//        int i =array2.bSearch(3);
//        System.out.println(array2.bSearch(3));

//        int[] nums=new int[]{2,7,11,15};
//        for (int i : LeetCode_1.twoSum(nums, 9)) {
//            System.out.println(i);
//        }

//        int[] nums= new int[]{-1, 0, 1, 2, -1, -4};
//        LeetCode_15.threeSum2(nums);
//        System.out.println(LeetCode_15.threeSum3(nums));

//        int[] nums = new int[]{2, 2, 1, 1, 3, 3, 2, 2, 2};
//        System.out.println(LeetCode_169.majorityElement2(nums));

        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(LeetCode_41.firstMissingPositive(nums));
    }
}
