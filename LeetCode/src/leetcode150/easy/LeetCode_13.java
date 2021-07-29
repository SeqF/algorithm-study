package leetcode150.easy;

/**
 * 罗马数字转整数
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode_13 {

    /**
     * 倒序遍历数组，根据规则IF ELSE
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int number = 0;
        if (s.length() == 0) {
            return number;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int j = i + 1;
            if (c == 'I') {
                if (j <= (s.length() - 1) && s.charAt(j) == 'V') {
                    number--;
                } else if (j <= (s.length() - 1) && s.charAt(j) == 'X') {
                    number--;
                } else {
                    number += 1;
                }
            } else if (c == 'V') {
                number += 5;
            } else if (c == 'X') {
                if (j <= (s.length() - 1) && s.charAt(j) == 'L') {
                    number -= 10;
                } else if (j <= (s.length() - 1) && s.charAt(j) == 'C') {
                    number -= 10;
                } else {
                    number += 10;
                }
            } else if (c == 'L') {
                number += 50;
            } else if (c == 'C') {
                if (j <= (s.length() - 1) && s.charAt(j) == 'D') {
                    number -= 100;
                } else if (j <= (s.length() - 1) && s.charAt(j) == 'M') {
                    number -= 100;
                } else {
                    number += 100;
                }
            } else if (c == 'D') {
                number += 500;
            } else if (c == 'M') {
                number += 1000;
            }
        }
        return number;
    }
}
