package com.leetcode.arrow.offer.easy;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 */
public class Solution013 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

    }

    /**
     * 解题思路：
     * 对称二叉树定义： 对于树中 任意两个对称节点 L 和 R，一定有：
     * L.val = R.val ：即此两对称节点值相等。
     * L.left.val = R.right.val：即 L 的 左子节点 和 R的 右子节点 对称；
     * L.right.val = R.left.val：即 L 的 右子节点 和 R 的 左子节点 对称。
     * 根据以上规律，考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
     *
     * 算法流程：
     * isSymmetric(root) ：
     *
     * 特例处理： 若根节点 root 为空，则直接返回 true 。
     * 返回值： 即 recur(root.left, root.right) ;
     * recur(L, R) ：
     *
     * 终止条件：
     * 当 L和 R同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true；
     * 当 L或 R中只有一个越过叶节点： 此树不对称，因此返回 false；
     * 当节点 L 值 != 节点 R值： 此树不对称，因此返回 false ；
     * 递推工作：
     * 判断两节点 L.left 和 R.right 是否对称，即 recur(L.left, R.right) ；
     * 判断两节点 L.right 和 R.left是否对称，即 recur(L.right, R.left) ；
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     *
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 复杂度分析：
     *
     * 时间复杂度 O(N)： 其中 NN 为二叉树的节点数量，每次执行 recur() 可以判断一对节点是否对称，因此最多调用 N/2次 recur() 方法。
     * 空间复杂度 O(N)： 最差情况下（见下图），二叉树退化为链表，系统使用 O(N)大小的栈空间。
     *

     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);

    }

    public static boolean recur(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }
        if (lNode == null || rNode == null || lNode.val != rNode.val) {
            return false;
        }
        return recur(lNode.left, rNode.right) && recur(lNode.right, rNode.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
