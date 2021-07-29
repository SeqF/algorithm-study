package recursion.base;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Offer_10_I {

    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new Offer_10_I().fib(2));
    }
}
