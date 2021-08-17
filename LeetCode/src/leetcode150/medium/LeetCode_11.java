package leetcode150.medium;

/**
 * 盛最多水的容器
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/container-with-most-water/
 */
public class LeetCode_11 {

    /**
     * 双指针遍历height，检查每次的maxArea值，然后往height[i]小的方向移动
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                maxArea = Math.max(maxArea, (high - low) * height[low]);
                low++;
            }else {
                maxArea = Math.max(maxArea, (high - low) * height[high]);
                high--;
            }
        }
        return maxArea;
    }
}
