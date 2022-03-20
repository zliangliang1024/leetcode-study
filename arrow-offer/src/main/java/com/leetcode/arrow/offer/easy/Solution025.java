package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution025 {
    int res,k;

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前提：二叉搜索树的中序遍历为递增序列，所以倒序为递减序列
     * 解题思路：
     * 本文解法基于此性质：二叉搜索树的中序遍历为 递增序列 。
     *
     * 根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
     * 因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。
     *
     * 中序遍历 为 “左、根、右” 顺序，递归法代码如下：
     *
     * // 打印中序遍历
     * void dfs(TreeNode root) {
     *     if(root == null) return;
     *     dfs(root.left); // 左
     *     System.out.println(root.val); // 根
     *     dfs(root.right); // 右
     * }
     *
     * 中序遍历的倒序 为 “右、根、左” 顺序，递归法代码如下：
     * # 打印中序遍历倒序
     *
     * // 打印中序遍历倒序
     * void dfs(TreeNode root) {
     *     if(root == null) return;
     *     dfs(root.right); // 右
     *     System.out.println(root.val); // 根
     *     dfs(root.left); // 左
     * }
     *
     *
     * 为求第 kk 个节点，需要实现以下 三项工作 ：
     * 递归遍历时计数，统计当前节点的序号；
     * 递归到第 kk 个节点时，应记录结果 resres ；
     * 记录结果后，后续的遍历即失去意义，应提前终止（即返回）。
     * 递归解析：
     * 终止条件： 当节点 rootroot 为空（越过叶节点），则直接返回；
     * 递归右子树： 即 dfs(root.right)dfs(root.right) ；
     * 三项工作：
     * 提前返回： 若 k = 0k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
     * 统计序号： 执行 k = k - 1k=k−1 （即从 kk 减至 00 ）；
     * 记录结果： 若 k = 0k=0 ，代表当前节点为第 kk 大的节点，因此记录 res = root.valres=root.val ；
     * 递归左子树： 即 dfs(root.left)dfs(root.left) ；
     *
     *
     * 复杂度分析：
     * 时间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N，占用 O(N) 时间。
     * 空间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
