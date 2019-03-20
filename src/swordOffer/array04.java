package swordOffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历
 * 序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Created by ZXL on 2019/3/5.
 */
public class array04 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = null;
        root = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static TreeNode reConstruct(int[] pre, int preStart, int preEnd,
                                int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart])
                break;
        }
        if (preStart < preEnd && inStart < inEnd) {
            root.left = reConstruct(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
            root.right = reConstruct(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
        }
        return root;
    }

    public static void main(String args[]) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode result = reConstructBinaryTree(pre, in);
        System.out.println(result.right.right.val);
    }
}
