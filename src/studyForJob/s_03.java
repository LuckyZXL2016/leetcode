package studyForJob;

/**
 * 二叉树对称
 * Created by ZXL on 2019/8/29.
 */
public class s_03 {
    private static boolean isSymmetrical(TreeNode root) {
        if (root == null) return false;
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
