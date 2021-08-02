package leetcode150.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author paksu
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode_49 {

    /**
     * 思路就是对字符串进行排序，排序后的作为key存入map中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //正常写法
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        //用Stream写法
        new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return Arrays.toString(chars);
        })).values());

        return new ArrayList<>(map.values());
    }
}
