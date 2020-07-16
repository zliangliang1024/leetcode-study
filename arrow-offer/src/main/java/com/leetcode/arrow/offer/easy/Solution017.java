package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Solution017 {

    public static void main(String[] args) {


    }

    /**
     * 解题思路：
     * 第一时间想到的解法：
     * 先遍历统计链表长度，记为 n；
     * 设置一个指针走 (n-k)步，即可找到链表倒数第 k个节点。
     * 使用双指针则可以不用统计链表长度。
     *
     *
     * 算法流程：
     * 初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head​ 。
     * 构建双指针距离： 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
     * 双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k-1k−1，即 latter 指向倒数第 kk 个节点）。
     * 返回值： 返回 latter 即可。
     *
     *
     * 复杂度分析：
     * 时间复杂度 O(N) ： N为链表长度；总体看， former 走了 N步， latter 走了 (N-k)步。
     * 空间复杂度 O(1) ： 双指针 former , latter 使用常数大小的额外空间。
     * 代码：
     * 本题没有 k大于链表长度的 case ，因此不用考虑越界问题。
     * 考虑越界问题的代码请见第三、四栏。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }
        ListNode later = head, former = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            later = later.next;
        }
        return later;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
