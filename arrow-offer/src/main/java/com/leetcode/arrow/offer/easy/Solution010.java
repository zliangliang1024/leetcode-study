package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution010 {

    public static void main(String[] args) {
        System.out.println(solution(9));

    }

    /**
     * 转为二进制，然后循环统计
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param num
     * @return
     */
    public static int solution(int num) {
        String binaryString = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * java 内部方法
     *
     * @param num
     * @return
     */
    public static int solution02(int num) {
        return Integer.bitCount(num);
    }


    /**
     * 巧用 n & (n - 1)
     * (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
     * n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
     *
     * n = 10101000
     * n-1 = 10100111
     * n&(n-1) = 10100000
     * <p>
     * 算法流程：
     * 初始化数量统计变量 res 。
     * 循环消去最右边的 1 ：当 n=0 时跳出。
     * res += 1 ： 统计变量加 1 ；
     * n &= n - 1 ： 消去数字 n 最右边的 1 。
     * 返回统计数量 res 。
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(M) ： n&(n−1) 操作仅有减法和与运算，占用 O(1) ；
     * 设 M 为二进制数字 n 中 1 的个数，则需循环 M 次（每轮消去一个 1 ），占用 O(M) 。
     * 空间复杂度 O(1) ： 变量 res 使用常数大小额外空间。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public static int solution03(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num &= num - 1;
        }
        return res;
    }
}
