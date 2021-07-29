package leetcode150.easy;

import java.util.Arrays;

/**
 * 加一
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one/
 */
public class LeetCode_66 {

    /**
     * 从数组末尾开始加，根据是否>=10来判断进位
     * 1、有进位时，检查数组所有元素，是否有依次进位
     * 2、当数组所有元素都有进位时，即最后up>0,此时数组要进行扩容
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int j = length - 1;
        int up = 0;
        digits[j] += 1;
        if (digits[j] >= 10) {
            while (j >= 0) {
                if (up > 0) {
                    digits[j] += up;
                    up = 0;
                }
                if (digits[j] >= 10) {
                    up = (digits[j] + 1) / 10;
                    digits[j] = (digits[j]) % 10;
                }
                j--;
            }
        }
        if (up > 0) {
            int[] result = new int[length + 1];
            Arrays.fill(result, 0);
            result[0] = up;
            return result;
        }
        return digits;
    }

    /**
     * 简化操作，根据上面的思路，up也只有0或1的值
     * 1、有进位时，就是继续遍历数组，并+1判断;当无进位时就直接返回
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            //之后+1之后与10取余的结果为0时，才是有进位
            //所有通过再次与10取余来判断是否0
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
