package leetcode150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class LeetCode_131 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    /**
     * 查找子集的基础上判断回文串
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    private void backTracking(String s, int startIndex) {
        //递归出口为startIndex到了字符串的尾部
        if (startIndex > s.length()-1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startIndex, i+1))) {
                path.add(s.substring(startIndex, i+1));
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //判断是否为回文串
    boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_131 code131 = new LeetCode_131();
        List<List<String>> list = code131.partition("aab");
        System.out.println(list.toString());

    }
}
