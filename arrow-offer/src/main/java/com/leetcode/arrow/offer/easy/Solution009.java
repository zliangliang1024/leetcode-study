package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Solution009 {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 0, 1};
        System.out.println(solution01(a));

    }

    /**
     * 解题思路：
     * 如下图所示，寻找旋转数组的最小元素即为寻找 右排序数组 的首个元素 numbers[x] ，称 xx 为 旋转点 。
     * 排序数组的查找问题首先考虑使用 二分法 解决，其可将遍历法的 线性级别 时间复杂度降低至 对数级别 。
     * <p>
     * <p>
     * 算法流程：
     * 循环二分： 设置 ii, jj 指针分别指向 numbers 数组左右两端，m = (i + j) // 2m=(i+j)//2 为每次二分的中点（ "//" 代表向下取整除法，因此恒有 i \leq m < ji≤m<j ），可分为以下三种情况：
     * 当 numbers[m] > numbers[j]时： mm 一定在 左排序数组 中，即旋转点 xx 一定在 [m + 1, j][m+1,j] 闭区间内，因此执行 i = m + 1i=m+1；
     * 当 numbers[m] < numbers[j] 时： mm 一定在 右排序数组 中，即旋转点 xx 一定在[i, m][i,m] 闭区间内，因此执行 j = mj=m；
     * 当 numbers[m] == numbers[j] 时： 无法判断 mm 在哪个排序数组中，即无法判断旋转点 xx 在 [i, m][i,m] 还是 [m + 1, j][m+1,j] 区间中。解决方案： 执行 j = j - 1j=j−1 缩小判断范围 （分析见以下内容） 。
     * 返回值： 当 i = ji=j 时跳出二分循环，并返回 numbers[i] 即可。
     * 思考： 是否可以用 numbers[m] 和 numbers[i] 比较做代替？
     * 解析： 不可以。因为做比较的目的是判断 mm 在哪个排序数组中。但在 numbers[m] > numbers[i]情况下，无法判断 mm 在哪个排序数组中。本质是因为 jj 初始值肯定在右排序数组中； ii 初始值无法确定在哪个排序数组中。
     * 示例： 当 i = 0, j = 4, m = 2i=0,j=4,m=2 时，有 numbers[m] > numbers[i] ，以下两示例得出不同结果。
     * numbers = [1, 2, 3, 4 ,5]numbers=[1,2,3,4,5] 旋转点 x = 0x=0 ： mm 在右排序数组（此示例只有右排序数组）；
     * numbers = [3, 4, 5, 1 ,2]numbers=[3,4,5,1,2] 旋转点 x = 3x=3 ： mm 在左排序数组。
     * <p>
     * 展开分析 numbers[m] == numbers[j] 情况：
     * 无法判定 mm 在左（右）排序数组： 设以下两个旋转点值为 00 的示例数组，则当 i = 0i=0, j = 4j=4 时 m = 2m=2 ，两示例结果不同。
     * <p>
     * 例 [1, 0, 1, 1, 1][1,0,1,1,1] ：旋转点 x = 1x=1 ，因此 m = 2m=2 在 右排序数组 中。
     * 例 [1, 1, 1, 0, 1][1,1,1,0,1] ：旋转点 x = 3x=3 ，因此 m = 2m=2 在 左排序数组 中。
     * j = j - 1j=j−1 操作的正确性证明： 只需证明每次执行此操作后，旋转点 xx 仍在 [i, j][i,j] 区间内即可。
     * <p>
     * 若 mm 在右排序数组中： numbers[m] == numbers[j] ，因此数组 [m, j][m,j]（恒有 m < jm<j）区间内所有元素值相等，执行 j = j - 1j=j−1 只会抛弃一个重复值，因此旋转点 xx 仍在 [i, j][i,j] 区间内。
     * 若 mm 在左排序数组中： 由于 左排序数组 任一元素 >= 右排序数组 任一元素 ，因此可推出旋转点元素值 numbers[x] <= numbers[j] == numbers[m]，则有：
     * 若 numbers[x] < numbers[j] ： 即 jj 左方仍有值更小的元素，执行 j = j - 1j=j−1 后旋转点 xx 仍在 [i, j][i,j] 区间内。
     * 若 numbers[x] == numbers[j] ： 分为以下两种情况。
     * 当 j>xj>x ： 易得执行 j = j - 1j=j−1 后旋转点 xx 仍在 [i, j][i,j] 区间内。
     * 当 j=xj=x： 特殊情况，即执行 j = j - 1j=j−1 后旋转点 xx 可能不在 [i, j][i,j] 区间内。例如 [1, 1, 1, 2, 3, 1][1,1,1,2,3,1] ，当 i = 0i=0 , m = 2m=2 , j = 5j=5 时执行 j = j - 1j=j−1 后虽然 丢失了旋转点索引 x = 5x=5 ，但最终返回值仍正确（最终返回的 numbers[0] 等于旋转点值 numbers[5] ），这是因为：之后的二分循环一直在执行 j = mj=m ，而区间 [i, m][i,m] 内的元素值一定都等于旋转点值 numbers[x] （ ∵ 区间内元素值既要满足 \geq≥ 也要满足 \leq≤ numbers[x]） ，因此 仍可保证正确的返回值 。
     * 总结： 此方法可以保证返回值 numbers[i] 等于旋转点值 numbers[x] ；但在少数特例下 ii 不是旋转点 xx 。本题目只要求返回 “旋转点的值” ，因此本方法可行。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param numbers
     * @return
     */
    public static int solution01(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                // 证明旋转点x在[m+1,j]（原本小的旋转到右边了,所以m在左排序中）
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                // 证明旋转点x在[i,m]（原本小的旋转到右边了,所以m在右排序中）
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    /**
     * 未正确解答，旋转点并不一定是中心点【理解有误】
     *
     * @param arr
     * @return
     */
    public static int solution(int[] arr) {
        if (arr.length <= 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.min(arr[0], arr[1]);
        }
        int mid = arr.length / 2;
        return arr[mid + 1];
    }
}
