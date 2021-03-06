package leetCode.tree;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * Created by ZXL on 2019/7/12.
 *
 * 示例 1:                 示例 2:
 * 输入: [1,2,3]           输入: [-10,9,20,null,null,15,7]
 *   1                      -10
 *  / \                     / \
 * 2   3                   9  20
 * 输出: 6                    /  \
 *                          15   7
 *                              输出: 42
 */
public class tr02 {
    static int max_sum = Integer.MIN_VALUE;

    public static int max_gain(TreeNode node) {
        if (node == null) return 0;

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        int price_newpath = node.val + left_gain + right_gain;
        max_sum = Math.max(max_sum, price_newpath);

        return price_newpath;
    }

    public static int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(maxPathSum(t1));
    }
}
