package com.leetcode.arrow.offer.easy;

import java.util.Stack;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution012 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        left1.left = new TreeNode(1);
        left1.right = new TreeNode(3);
        right1.left = new TreeNode(6);
        right1.right = new TreeNode(9);
        TreeNode tree = mirrorTree(root);
        System.out.println(tree.left.right.val);


    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirrorTree(left);
        mirrorTree(right);
        return root;
    }

    /**
     * 二叉树镜像定义： 对于二叉树中任意节点 root，
     * 设其左 / 右子节点分别为 left, right,right ；
     * 则在二叉树的镜像中的对应 root节点，其左 / 右子节点分别为 right, left 。
     * <p>
     * 方法一：递归法
     * 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
     * 递归解析：
     * 终止条件： 当节点 root为空时（即越过叶节点），则返回 null ；
     * 递推工作：
     * 初始化节点 tmp，用于暂存 root的左子节点；
     * 开启递归 右子节点 mirrorTree(root.right)，并将返回值作为 root的 左子节点 。
     * 开启递归 左子节点 mirrorTree(tmp)，并将返回值作为 root的 右子节点 。
     * 返回值： 返回当前节点 root；
     * Q： 为何需要暂存 root的左子节点？
     * A： 在递归右子节点 “root.left=mirrorTree(root.right);” 执行完毕后， root.left 的值已经发生改变，
     * 此时递归左子节点 mirrorTree(root.left)则会出问题。
     * <p>
     * 杂度分析：
     * 时间复杂度 O(N)： 其中 N为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)时间。
     * 空间复杂度 O(N)： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N)大小的栈空间。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @return
     */
    public static TreeNode mirrorTree02(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /**
     * 方法二：辅助栈（或队列）
     * 利用栈（或队列）遍历树的所有节点 node ，并交换每个 node的左 / 右子节点。
     * 算法流程：
     * 特例处理： 当 root为空时，直接返回 null；
     * 初始化： 栈（或队列），本文用栈，并加入根节点 root 。
     * 循环交换： 当栈 stack为空时跳出；
     * 出栈： 记为 node；
     * 添加子节点： 将 node 左和右子节点入栈；
     * 交换： 交换 node 的左 / 右子节点。
     * 返回值： 返回根节点 root。
     *
     * 复杂度分析：
     * 时间复杂度 O(N)： 其中 NN 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N) 时间。
     * 空间复杂度 O(N)： 最差情况下（当为满二叉树时），栈 stack最多同时存储 N/2N/2 个节点，占用 O(N) 额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode mirrorTree03(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>() {
            {
                add(root);
            }
        };
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
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
