package examination.baidu;

/**
 * 判断树是否对称
 * Created by ZXL on 2019/8/3.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class b_01 {

    private boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compRoot(root.left, root.right);
    }

    private boolean compRoot(TreeNode lroot, TreeNode rroot) {
        if (null == lroot) return (null == rroot);
        if (null == rroot) return false;
        if (lroot.val != rroot.val) return false;
        return compRoot(lroot.left, rroot.right) && compRoot(lroot.right, rroot.left);
    }

    public static void main(String[] args) {
        b_01 example = new b_01();
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
