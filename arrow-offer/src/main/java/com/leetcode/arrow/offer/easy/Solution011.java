package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 */
public class Solution011 {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//
//        ListNode cur = mergeTwoLists(l1, l2);
//        while (cur != null) {
//            System.out.println(cur.val);
//            cur = cur.next;
//        }

        ListNode dum = new ListNode(0), cur = dum;
        // 证明cur是引用，实际操作的还是dum
        cur.next = new ListNode(1);
        System.out.println(dum.next.val);


    }

    /**
     * 解题思路：
     * 根据题目描述， 链表 l_1, l_2是 递增 的，因
     * 此容易想到使用双指针 l_1和 l_2遍历两链表，根据 l_1.val和 l_2.val的大小关系确定节点添加顺序，
     * 两节点指针交替前进，直至遍历完毕。
     * 引入伪头节点： 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。
     *
     * 解决方案：初始化一个辅助节点 dum 作为合并链表的伪头节点，将各节点添加至 dum之后。
     *
     * 算法流程：
     * 初始化： 伪头节点 dum ，节点 cur指向 dum 。
     * 循环合并： 当 l_1,l_2l]为空时跳出；
     * 当 l_1.val < l_2.val时： cur的后继节点指定为 l_1，并 l_1向前走一步；
     * 当 l_1.val \geq l_2.val时： cur的后继节点指定为 l_2l，并 l_2向前走一步 ；
     * 节点 cur 向前走一步，即 cur = cur.next 。
     * 合并剩余尾部： 跳出时有两种情况，即 l_1为空 或 l_2为空。
     * 若 l_1 != null： 将 l_1添加至节点 cur之后；
     * 否则： 将 l_2l添加至节点 cur之后。
     * 返回值： 合并链表在伪头节点 dum 之后，因此返回 dum.next 即可。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/solution/mian-shi-ti-25-he-bing-liang-ge-pai-xu-de-lian-b-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 复杂度分析：
     * 时间复杂度 O(M+N) ： M,N 分别为链表 l_1, l_2的长度，合并操作需遍历两链表。
     * 空间复杂度 O(1) ： 节点引用 dum , cur 使用常数大小的额外空间。,
     * 只有建立头节点的时候会开启一个内存空间，其余的内存空间都是使用l1
     * 和l2的，所以空间复杂度未O(1）
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        // 当前的节点的尾部节点
        cur.next = l1 != null ? l1 : l2;
        // 伪节点的下一个即最后的结果
        return dum.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
