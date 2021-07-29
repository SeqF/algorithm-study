package leetcode150.easy;

/**
 * Excel表列序号
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class LeetCode_171 {

    /**
     * 26进制转10进制
     * 用2进制转10进制来对比
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int number = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            number += ((int) columnTitle.charAt(i) - 'A' + 1) * (Math.pow(26, columnTitle.length() - 1 - i));
        }
        return number;
    }

    public static void main(String[] args) {
        LeetCode_171 code171 = new LeetCode_171();
        System.out.println(code171.titleToNumber("AAAAAAA"));
    }

}
