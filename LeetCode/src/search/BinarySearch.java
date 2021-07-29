package search;

/**
 * 二分查找
 *
 * @author paksu
 */
public class BinarySearch {

    /**
     * 二分查找针对的是一个有序的数据集合，查找思想有点类似分支思想，每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一般，
     * 直到找到要查找的元素，或者区间被缩小为0
     * <p>
     * 注意：
     * 1、二分查找依赖的是顺序表结构，就是数组，因为需要实现随机访问
     * 2、针对的是有序数据
     * 3、数据量太小不适合二分查找
     * 4、数据量太大也不适合，因为二分查找依赖的是顺序表，需要连续的存储空间
     * <p>
     * 时间复杂度O(logn)，
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    //非递归实现
    public int bSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            //先做除法运算，防止溢出
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    //递归实现
    private int bSearchInternally(int[] a, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bSearchInternally(a, mid + 1, high, value);
        } else {
            return bSearchInternally(a, low, mid - 1, value);
        }

    }

    /**
     * 二分查找的4种常见变形
     * 1、查找第一个等于给定值的元素
     * 2、查找最后一个值等于给定值的元素
     * 3、查找第一个大于等于给定值的元素
     * 4、查找最后一个小于等于给定值的元素
     * <p>
     * 下面例子中，数据都是从小到大排序
     *
     * @return
     */

    //变体一：查找第一个值等于给定值的元素
    public int bSearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                /**
                 * 这里就是a[mid]=value的情况，当相等时，就要判断是否为第一个找到的元素，
                 * 有两种情况来判断：
                 *   1、当mid=0，即为数组第一个元素时，那找到的数据就为第一个
                 *   2、当 mid的前一个下标的值不等于value时，找到的数据就为第一个
                 * 如果都不符合，就往前继续查找
                 */
                if ((mid == 1) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //变体二：查找最后一个值等于给定值的元素
    public int bSearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                /**
                 * 这里就是a[mid]=value的情况，当相等时，就要判断是否为最后一个找到的元素，
                 * 有两种情况来判断：
                 *   1、当mid=n-1，即为数组第一个元素时，那找到的数据就为最后一个元素
                 *   2、当 mid的后一个下标的值不等于value时，找到的数据就为最后一个
                 * 如果都不符合，就往后继续查找
                 */
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //变体三：查找第一个大于等于给定值的元素
    public int bSearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //变体四：查找最后一个小于等于给定值的元素
    public int bSearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == n - 1) || a[mid + 1] <= value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
