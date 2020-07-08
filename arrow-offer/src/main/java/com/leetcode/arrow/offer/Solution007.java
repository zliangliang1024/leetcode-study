package com.leetcode.arrow.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
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
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Solution007 {
    public static void main(String[] args) {
        System.out.println(solution02(0));
        System.out.println(solution02(1));
        System.out.println(solution02(2));
        System.out.println(solution02(10));

    }


    /**
     * 递归法：
     * 原理： 把 f(n)f(n) 问题的计算拆分成 f(n-1)f(n−1) 和 f(n-2)f(n−2) 两个子问题的计算，并递归，以 f(0)f(0) 和 f(1)f(1) 为终止条件。
     * 缺点： 大量重复的递归计算，例如 f(n)f(n) 和 f(n - 1)f(n−1) 两者向下递归需要 各自计算 f(n - 2)f(n−2) 的值。
     * 时间复杂度：类似于二叉树的节点 O(2^n)
     * 空间复杂度：二叉树的高度O(n)
     *
     * @param n
     * @return
     */
    static int solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution(n - 1) + solution(n - 2);
    }

    /**
     * 动态规划：
     * 原理： 以斐波那契数列性质 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1) 为转移方程。
     * 从计算效率、空间复杂度上看，动态规划是本题的最佳解法。
     * <p>
     * 动态规划解析：
     * 状态定义： 设 dp 为一维数组，其中 dp[i]的值代表 斐波那契数列第 i个数字 。
     * 转移方程： dp[i+1]=dp[i]+dp[i−1] ，即对应数列定义 f(n + 1) = f(n) + f(n - 1)；
     * 初始状态： dp[0] = 0, dp[1] = 1，即初始化前两个数字；
     * 返回值： dp[n] ，即斐波那契数列的第 n 个数字。
     * 空间复杂度优化：
     * 若新建长度为 n的 dp列表，则空间复杂度为 O(N)。
     * <p>
     * 由于 dp 列表第 i 项只与第 i-1和第 i-2项有关，因此只需要初始化三个整形变量 sum, a, b ，
     * 利用辅助变量 sum 使 a, b两数字交替前进即可 （具体实现见代码） 。
     * 节省了 dp 列表空间，因此空间复杂度降至 O(1)。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @return
     */
    static int solution02(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
