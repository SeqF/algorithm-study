package leetcode150.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387 {

    /**
     * 判断不了结束条件
     *
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int slow = 0;
        int fast = 1;
        while (fast < s.length()) {
            if (s.charAt(fast) == s.charAt(slow)) {
                slow++;
                fast = slow + 1;
            } else {
                fast++;
            }
        }
        return slow == s.length() - 1 ? -1 : slow;
    }

    /**
     * 用map来保存对应字符和出现次数，然后返回出现次数为1的下标
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
