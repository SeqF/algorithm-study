package recursion.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Offer_38 {

    /**
     * 用回溯算法，类似于树的深度遍历
     * 回溯算法参考文章：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        //保存排列结果
        List<String> res = new ArrayList<>();
        //遍历的路径，即组合的结果
        StringBuilder path = new StringBuilder();
        //检查被使用过的字符
        boolean[] used = new boolean[length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        dfs(chars, length, 0, path, used, res);

        return res.stream().distinct().toArray(String[]::new);
    }

    public void dfs(char[] chars, int length, int depth, StringBuilder path, boolean[] used, List<String> res) {
        if (depth == length) {
            //递归出口
            res.add(path.toString());
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                //遍历开始前(进入下一分支前）
                path.append(chars[i]);
                used[i] = true;
                //继续向下遍历
                dfs(chars, length, depth + 1, path, used, res);
                //遍历结束后(返回上一个分支前）
                //撤销操作
                path.delete(path.length() - 1, path.length());
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Offer_38 offer38 = new Offer_38();
        String test1 = "aab";
        System.out.println(Arrays.toString(offer38.permutation(test1)));
    }
}
