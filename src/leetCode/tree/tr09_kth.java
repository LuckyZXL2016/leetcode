package leetCode.tree;

/**
 * 二叉树第k大元素
 * Created by ZXL on 2019/8/10.
 */
public class tr09_kth {
    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        count--;
        if (count == 0) {
            this.res = node.val;
        }
        dfs(node.left);
    }

    public int kthBiggest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        int val = new tr09_kth().kthBiggest(t1, 1);
        System.out.println(val);
    }
}
