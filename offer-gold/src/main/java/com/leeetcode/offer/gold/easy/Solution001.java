package com.leeetcode.offer.gold.easy;

/**
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 示例 1：
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 */
public class Solution001 {

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};
        int res = solution001(nums);
        System.out.println(res);

        System.out.println(solution002(nums));

    }

    /**
     * 利用异或的特性，res = res ^ x ^ x。对同一个值异或两次(因为后面两个相同的值异或会消失)，那么结果等于它本身，
     * 所以我们对res从0-nums.length进行异或，同时对nums数组中的值进行异或，出现重复的会消失，
     * 所以最后res的值是只出现一次的数字，也就是nums数组中缺失的那个数字。
     *
     * 异或具有交换律和结合律
     * 所以相同的会消失
     *
     * 作者：LSZ
     * 链接：https://leetcode-cn.com/problems/missing-number-lcci/solution/onshi-jian-fu-za-du-o1kong-jian-fu-za-du-shi-xian-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     */
    private static int solution002(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
             res ^= i;
             res ^= nums[i];
        }
        res ^=nums.length;
        return res;

    }

    /**
     * 解法一：因为数组是连续的自然数，所以对数组长度的自然数求和-给定数组之和即为消失的数字
     * 空间复杂度O(1),时间复杂度O(n)
     * @param nums
     * @return
     */
    private static int solution001(int[] nums) {
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        int sum = nums.length * (nums.length + 1) / 2;
        return sum - arraySum;
    }



}
