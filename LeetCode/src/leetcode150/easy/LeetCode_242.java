package leetcode150.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode_242 {

    /**
     * 利用map来进行计数，一开始分别为两个字符串设立map，时间复杂度和空间复杂度较高
     * 改为用一个map来保存，将t字符串的值取出并-1来校验是否符合s，使用getOrDefault方法来进行值的设置，
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();

        Map<Character, Integer> map = new HashMap<>(sLength);
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            //这里是精髓，通过-1来进行校验不用每次都get出来判等
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

}
