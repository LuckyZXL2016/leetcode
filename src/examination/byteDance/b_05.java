package examination.byteDance;

/**
 * 判断树是否对称
 * Created by ZXL on 2019/8/15.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}

public class b_05 {
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

    public static void main(String[] args) {
        b_05 example = new b_05();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(example.isSymmetrical(t1));
    }
}
