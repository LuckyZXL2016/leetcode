package studyForJob;

/**
 * 二叉树第K大元素
 * Created by ZXL on 2019/8/29.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}

public class s_02 {
    private static int k = 0;
    private static int value = 0;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        k = 3;
        getKthBigest(t1);
    }

    private static void getKthBigest(TreeNode root) {
        dfs(root);
        System.out.println(value);
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);
        k--;
        if (k == 0) {
            value = root.val;
        }
        dfs(root.left);
    }
}
