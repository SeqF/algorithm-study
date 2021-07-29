package leetcode150.easy;

/**
 * 位1的个数
 *
 * @author paksu
 */
public class LeetCode_191 {

    /**
     * 位运算:n&(n-1)，其运算结果会把n的二进制位中的最低位1变为0
     * 如：6&(6-1)=4     6的二进制：110     4的二进制：100
     * 这样可以让n与n-1不断的做&(与)运算，直到n变为0，其中运算次数就为1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
