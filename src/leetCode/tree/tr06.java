package leetCode.tree;

/**
 * 递归遍历二叉树
 * Created by ZXL on 2019/7/29.
 */
public class tr06 {
    // 先序
    private void pre_traverse(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            pre_traverse(root.left);
            pre_traverse(root.right);
        }
    }

    // 中序
    private void in_traverse(TreeNode root) {
        while (root != null) {
            in_traverse(root.left);
            System.out.print(root.val + " ");
            in_traverse(root.right);
        }
    }

    // 后序
    private void beh_traverse(TreeNode root) {
        while (root != null) {
            beh_traverse(root.left);
            beh_traverse(root.right);
            System.out.print(root.val + " ");
        }
    }
}
