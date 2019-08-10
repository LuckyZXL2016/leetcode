package leetCode.tree;

/**
 * 二叉树第k大元素
 * Created by ZXL on 2019/8/10.
 */
public class tr09_kth {
    private int count = 0;
    private int val = 0;

    private int kthNode(TreeNode root, int k) {
        count = k;
        dfs(root);
        return val;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        count--;

    }
}
