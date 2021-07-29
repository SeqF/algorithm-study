package leetcode150.easy;

/**
 * 阶乘后的零
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class LeetCode_172 {

    public int trailingZeroes(int n) {
        int count = 0;
        if (n == 0) {
            return count;
        }
        int factorial = getFactorial(n);
        String s = Integer.toString(factorial);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                return count;
            }
            count++;
        }
        return count;
    }

    private int getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return getFactorial(n - 1) * n;
    }
}
