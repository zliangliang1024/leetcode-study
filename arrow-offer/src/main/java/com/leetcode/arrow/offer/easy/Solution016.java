package com.leetcode.arrow.offer.easy;

import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 输入: n = 2  长度为:10^n-1
 * 输出: [1,2,3,4,5,6,7,8,9...22...99]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Solution016 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    /**
     * 时间复杂度 O(10^n)：生成长度为 10^n的列表需使用 O(10^n)时间。
     * 空间复杂度 O(1)：建立列表需使用 O(1) 大小的额外空间（列表作为返回结果，不计入额外空间）。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] res = new int[len];
        for (int i = 0; i <= len; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * todo 大数解法，利用String遍历
     */
}
