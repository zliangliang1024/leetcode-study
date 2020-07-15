package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Solution015 {

    public static void main(String[] args) {

    }

    /**
     * a[0][0] a[0][1] a[0][2] a[0][3]
     * a[1][3] a[2][3] a[2][2] a[2][1]
     * a[2][0] a[1][0] a[1][1] a[1][2]
     *
     * 解题思路：
     * 根据题目示例 matrix = [[1,2,3],[4,5,6],[7,8,9]] 的对应输出 [1,2,3,6,9,8,7,4,5]
     * 可以发现，顺时针打印矩阵的顺序是 “从左向右、从上向下、从右向左、从下向上” 循环。
     *
     * 因此，考虑设定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序。
     *
     *
     * 算法流程：
     * 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
     * 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
     * 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
     * 根据边界打印，即将元素按顺序添加至列表 res 尾部；
     * 边界向内收缩 1 （代表已被打印）；
     * 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
     * 返回值： 返回 res 即可。
     * 打印方向	1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
     * 从左向右	左边界l ，右边界 r	上边界 t 加 1	是否 t > b
     * 从上向下	上边界 t ，下边界b	右边界 r 减 1	是否 l > r
     * 从右向左	右边界 r ，左边界l	下边界 b 减 1	是否 t > b
     * 从下向上	下边界 b ，上边界t	左边界 l 加 1	是否 l > r
     * 复杂度分析：
     * 时间复杂度 O(MN) ： M, N分别为矩阵行数和列数。
     * 空间复杂度 O(1)： 四个边界 l , r , t , b 使用常数大小的 额外 空间（ res 为必须使用的空间）。
     *
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i > l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i > t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
