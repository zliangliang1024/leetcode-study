package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Solution019 {

    public static void main(String[] args) {

    }


    /**
     * 解题思路：
     * 删除值为 val 的节点可分为两步：定位节点、修改引用。
     *
     * 定位节点： 遍历链表，直到 head.val == val 时跳出，即可定位目标节点。
     * 修改引用： 设节点 cur 的前驱节点为 pre ，后继节点为 cur.next ；则执行 pre.next = cur.next ，即可实现删除 cur 节点。
     *
     *
     * 算法流程：
     * 特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
     * 初始化： pre = head , cur = head.next 。
     * 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
     * 保存当前节点索引，即 pre = cur 。
     * 遍历下一节点，即 cur = cur.next 。
     * 删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next 。（若 cur 指向 null ，代表链表中不包含值为 val 的节点。
     * 返回值： 返回链表头部节点 head 即可。
     *
     * 复杂度分析：
     * 时间复杂度 O(N) ： NN 为链表长度，删除操作平均需循环 N/2 次，最差 N 次。
     * 空间复杂度 O(1) ： cur, pre 占用常数大小额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            pre.next = cur.next;
        }
        // if cur == null ，证明没有要删除的值
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



