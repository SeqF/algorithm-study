package leetcode150.easy;

/**
 * 验证回文串
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-palindrome/
 */
public class LeetCode_125 {

    /**
     * 用双指针，一头一尾往中间夹，比较前每次都要先定位到字符或数组
     * Character.isLetterOrDigit 判断是否为字母或数字
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
