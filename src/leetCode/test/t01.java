package leetCode.test;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * Created by ZXL on 2019/7/29.
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回它的最大深度 3 。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class t01 {
    private int maxDep(TreeNode root) {
        if (root == null) return 0;
        int leftNum = maxDep(root.left);
        int rightNum = maxDep(root.right);

        return Math.max(leftNum, rightNum) + 1;
    }
}
