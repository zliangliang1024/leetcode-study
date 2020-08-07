package com.leetcode.arrow.offer.easy;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8 这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Solution024 {


    public static void main(String[] args) {
        int[] arr = {12,3,5,11,10};

        System.out.println(Arrays.toString(getLeastNumbers(arr, 2)));

    }


    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 最后一个参数表示，我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k-1);
    }

    /**
     * 时间复杂度 O（N）
     * 空间复杂度 O (N)
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return
     */
    private static int[] quickSearch(int[] nums, int left, int right, int k) {
        // 每快排切分一次，找到排序后下标为j的元素，如果j恰好等于K就返回j以及j左边的元素
        int j = partition(nums, left, right);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }

        // 否则根据下标j与k的大小关系决定继续切分左边与右边
        return j > k ? quickSearch(nums, left, j - 1, k) : quickSearch(nums, j + 1, right, k);

    }

    /**
     * 快排切分，返回下标j，使num[j]左边的值都小于num[j],num[j]右边的值都大于num[j]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] nums, int left, int right) {
        int v = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (++i < j && nums[i] < v) ;
            while (--j > i && nums[j] > v) ;
            if (i > j) {
                break;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        // 最后一次替换
        nums[left] = nums[j];
        nums[j] = v;
        return j;
    }

}
