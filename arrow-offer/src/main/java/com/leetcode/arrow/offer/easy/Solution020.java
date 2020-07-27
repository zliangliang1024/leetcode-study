package com.leetcode.arrow.offer.easy;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution020 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

}


/**
 * 解题思路：
 * 普通栈的 push() 和 pop() 函数的复杂度为 O(1) ；而获取栈最小值 min() 函数需要遍历整个栈，复杂度为 O(N) 。
 *
 * 本题难点： 将 min() 函数复杂度降为 O(1)，可通过建立辅助栈实现；
 * 数据栈 A ： 栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 辅助栈 B ： 栈 B中存储栈 A中所有 非严格降序 的元素，则栈 A中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B的栈顶元素即可。
 * 因此，只需设法维护好 栈 B的元素，使其保持非严格降序，即可实现 min() 函数的 O(1) 复杂度。
 *
 *
 * 函数设计：
 * push(x) 函数： 重点为保持栈 BB 的元素是 非严格降序 的。
 *
 * 将 x压入栈 A （即 A.add(x) ）；
 * 若 ① 栈 B为空 或 ② xx 小于等于 栈 B 的栈顶元素，则将 x 压入栈 B （即 B.add(x) ）。
 * pop() 函数： 重点为保持栈 A, B的 元素一致性 。
 *
 * 执行栈 A 出栈（即 A.pop() ），将出栈元素记为 y ；
 * 若 y 等于栈 B 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
 * top() 函数： 直接返回栈 A 的栈顶元素即可，即返回 A.peek() 。
 *
 * min() 函数： 直接返回栈 B 的栈顶元素即可，即返回 B.peek() 。
 *
 *
 * 复杂度分析：
 * 时间复杂度 O(1)： push(), pop(), top(), min() 四个函数的时间复杂度均为常数级别。
 * 空间复杂度 O(N)： 当共有 N个待入栈元素时，辅助栈 B 最差情况下存储 N个元素，使用 O(N) 额外空间。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MinStack {

    private Stack<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || B.peek() >= x) {
            B.add(x);
        }

    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }

    }

    public int top() {
        return A.peek();

    }

    public int min() {
        return B.peek();
    }
}
