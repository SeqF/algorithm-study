package leetcode150.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fizz Buzz
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/fizz-buzz/
 */
public class LeetCode_412 {

    /**
     * 注意同时3和5的倍数要先判断
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        String[] list = new String[n];
        for (int i = 0; i < list.length; i++) {
            if ((i+1) % 3 == 0 && (i+1) % 5 == 0) {
                list[i] = "FizzBuzz";
            } else if ((i+1) % 5 == 0) {
                list[i] = "Buzz";
            } else if ((i+1) % 3 == 0 ) {
                list[i] = "Fizz";
            } else {
                list[i] = Integer.toString(i+1);
            }
        }
        return Arrays.asList(list);
    }
}
