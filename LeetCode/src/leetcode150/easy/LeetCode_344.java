package leetcode150.easy;

/**
 * 反转字符串
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-string/
 */
public class LeetCode_344 {

    /**
     * 原地倒序，没啥好说的，双指针往中间夹，交换
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}
