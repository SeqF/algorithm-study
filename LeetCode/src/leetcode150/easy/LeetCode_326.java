package leetcode150.easy;

/**
 * 3的幂
 *
 * @author paksu
 * <p>
 * 链接:https://leetcode-cn.com/problems/power-of-three/
 */
public class LeetCode_326 {

    /**
     * n%3 只要余数为 0，就一直将 n 除以 b,最终结果为1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n % 3 == 0 && n > 0) {
            n /= 3;
        }
        return n == 1;
    }
}
