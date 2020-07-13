package com.leetcode.arrow.offer.easy;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Solution014 {
    public static void main(String[] args) {
        int[] nums = {2,4,3,1};
        System.out.println(Arrays.toString(exchange(nums)));

    }

    /**
     * 解题思路：
     * 考虑定义双指针 i, j分列数组左右两端，循环执行：
     *
     * 指针 i从左向右寻找偶数；
     * 指针 j从右向左寻找奇数；
     * 将 偶数 nums[i]和 奇数 nums[j]交换。
     * 可始终保证： 指针 i左边都是奇数，指针 j右边都是偶数 。
     *
     *
     *
     * 算法流程：
     * 初始化： i, j双指针，分别指向数组 nums 左右两端；
     * 循环交换： 当 i = j时跳出；
     * 指针 ii 遇到奇数则执行 i=i+1 跳过，直到找到偶数；
     * 指针 jj 遇到偶数则执行 j=j−1 跳过，直到找到奇数；
     * 交换 nums[i]和 nums[j] 值；
     * 返回值： 返回已修改的 nums数组。
     *
     * 复杂度分析：
     * 时间复杂度 O(N)： N 为数组 nums长度，双指针 i, j共同遍历整个数组。
     * 空间复杂度 O(1)： 双指针 i, j使用常数大小的额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/mian-shi-ti-21-diao-zheng-shu-zu-shun-xu-shi-qi-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] % 2 == 1)) {
                // 奇数时跳过，即找到第一个偶数
                i++;
            }
            while (i < j && (nums[j] % 2 == 0)) {
                // 偶数时跳过，即找到第一个奇数
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
