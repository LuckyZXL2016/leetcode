package examination.java;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的
 * 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * Created by ZXL on 2019/8/8.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class j_01_treeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftValue = TreeDepth(root.left);
        int rightValue = TreeDepth(root.right);
        return Math.max(leftValue, rightValue) + 1;
    }
}
