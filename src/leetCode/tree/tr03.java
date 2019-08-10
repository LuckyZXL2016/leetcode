package leetCode.tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * Created by ZXL on 2019/7/18.
 *
 * 示例 :
 *  输入: root = [3,1,4,null,2], k = 1
 *      3
 *     / \
 *    1   4
 *     \
 *      2
 *  输出: 1
 */
public class tr03 {

    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            this.res = node.val;
        }
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
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

        int val = new tr03().kthSmallest(t1, 1);
        System.out.println(val);
    }
}
