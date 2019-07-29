package leetCode.test;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * Created by ZXL on 2019/7/29.
 *
 * 示例 1:                 示例 2:
 * 输入: [1,2,3]           输入: [-10,9,20,null,null,15,7]
 *   1                      -10
 *  / \                     / \
 * 2   3                   9  20
 * 输出: 6                    /  \
 *                          15   7
 *                              输出: 42
 * Created by ZXL on 2019/7/29.
 */
public class t02 {
    int max_sum = Integer.MIN_VALUE;

    private int max_gain(TreeNode root) {
        if (root == null) return 0;

        int leftValue = Math.max(max_gain(root.left), 0);
        int rightValue = Math.max(max_gain(root.right) ,0);
        int value = leftValue + rightValue + root.val;
        if (value > max_sum) max_sum = value;

        return value;
    }

    public static void main(String[] args) {
        t02 example = new t02();
//        TreeNode t1 = new TreeNode(-10);
//        TreeNode t2 = new TreeNode(9);
//        TreeNode t3 = new TreeNode(20);
//        TreeNode t4 = new TreeNode(15);
//        TreeNode t5 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        example.max_gain(t1);
        System.out.println(example.max_sum);
    }
}
