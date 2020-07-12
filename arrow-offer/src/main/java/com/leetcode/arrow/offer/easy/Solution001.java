package com.leetcode.arrow.offer.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution001 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 4, 5, 3};
        int solution = solution01(nums);
        System.out.println(solution);


    }

    /**
     * 时间复杂度和空间复杂度都为O(n)
     *
     * @param nums
     * @return
     */
    public static int solution01(int[] nums) {
        Map<Integer, Integer> tagMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (tagMap.get(nums[i]) == null || tagMap.get(nums[i]) == 0) {
                tagMap.put(nums[i], 1);
                continue;
            }
            tagMap.put(i, tagMap.get(nums[i]) + 1);
            return nums[i];
        }
        return -1;
    }

    /**
     * 时间复杂度和空间复杂度都为O(n)
     */
    public static int solution02(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


}
