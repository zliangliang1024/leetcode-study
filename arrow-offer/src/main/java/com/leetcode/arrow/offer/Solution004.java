package com.leetcode.arrow.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Solution004 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
//        int[] res = solution(head);
        int[] res02 = solution02(head);
//        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res02));

    }

    /**
     * 时间复杂度 O(2n)
     * 空间复杂度 O(2n)
     * @param head
     * @return
     */
    public static int[] solution(ListNode head) {
        List<Integer> tempList = new ArrayList<>();
        int[] res = new int[0];
        if(head == null){
            return res;
        }
        tempList.add(head.val);
        while (head.next != null) {
            tempList.add(head.next.val);
            head = head.next;
        }
        int j = 0;
        res = new int[tempList.size()];
        for (int i = tempList.size() - 1; i >= 0; i--) {
            res[j++] = tempList.get(i);
        }
        return res;

    }

    /**
     * 栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置。
     * 从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
     *
     * 创建一个栈，用于存储链表的节点
     * 创建一个指针，初始时指向链表的头节点
     * 当指针指向的元素非空时，重复下列操作：
     * 将指针指向的节点压入栈内
     * 将指针移到当前节点的下一个节点
     * 获得栈的大小 size，创建一个数组 print，其大小为 size
     * 创建下标并初始化 index = 0
     * 重复 size 次下列操作：
     * 从栈内弹出一个节点，将该节点的值存到 print[index]
     * 将 index 的值加 1
     * 返回 print
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 复杂性分析
     *
     * 时间复杂度：O(n)O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
     * 空间复杂度：O(n)O(n)。额外使用一个栈存储链表中的每个节点
     *
     * @param head
     * @return
     */
    public static int[] solution02(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            // 压栈
            stack.push(temp);
            // 指针下移
            temp = temp.next;
        }
        // 出栈，放入数组
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            // 从栈顶弹出
            print[i] = stack.pop().val;
        }
        return print;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
