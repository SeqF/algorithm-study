package leetcode150.easy;

/**
 * 外观数列
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/count-and-say/
 */
public class LeetCode_38 {

    /**
     * 用递归,是从最小开始往上返回，所以操作方法是在递归函数的后面
     * 每次对字符串进行计数，当元素不同时就把元素及其数量拼接起来，然后换下一个元素遍历
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return reCountAndSay(n);
    }

    public String reCountAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = reCountAndSay(n - 1);
        StringBuilder say = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                //这里保证了能拿到最后一个元素
                i++;
            }
            say.append(count).append(s.charAt(i));
        }
        return say.toString();
    }

    public static void main(String[] args) {
        LeetCode_38 code38 = new LeetCode_38();
        System.out.println(code38.countAndSay(4));
    }
}
